package com.enigma.wms_api.Service.ServiceImpl;


import com.enigma.wms_api.Entity.Branch;
import com.enigma.wms_api.Entity.Product;
import com.enigma.wms_api.Entity.ProductPrice;
import com.enigma.wms_api.Model.ModelRequest.ProductRequest;
import com.enigma.wms_api.Model.ModelResponse.BranchResponse;
import com.enigma.wms_api.Model.ModelResponse.ProductResponse;
import com.enigma.wms_api.Repository.ProductRepository;
import com.enigma.wms_api.Service.BranchService;
import com.enigma.wms_api.Service.ProductPriceService;
import com.enigma.wms_api.Service.ProductService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final BranchService branchService;

    private final ProductRepository productRepository;

    private final ProductPriceService productPriceService;

    private ProductResponse toProductResponse(Product product, ProductPrice productPrice, Branch branch){
        return ProductResponse.builder()
                .productId(product.getId())
                .productPriceId(product.getProductPriceId())
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .price(productPrice.getPrice())
                .branch(BranchResponse.builder()
                        .id(branch.getId())
                        .branchCode(branch.getBranchCode())
                        .name(branch.getName())
                        .address(branch.getAddress())
                        .phoneNumber(branch.getPhoneNumber())
                        .build())
                .build();
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Branch branch = branchService.getById(request.getBranchId());

        Product product = Product.builder()
                .productPriceId(request.getProductPriceId())
                .productCode(request.getProductCode())
                .productName(request.getProductName())
                .build();

        productRepository.saveAndFlush(product);

        ProductPrice productPrice = ProductPrice.builder()
                .price(request.getPrice())
                .isActive(true)
                .product(product)
                .branch(branch)
                .build();

        productPriceService.create(productPrice);

        return toProductResponse(product, productPrice, branch);
    }

    @Override
    public void deleteById(String id) {

    }

//    @Override
//    public Page<ProductResponse> getAll(Integer size, Integer page, String productCode, String productName, String minPrice, String maxPrice) {
//        Specification<Product> specification = (root, query, criteriaBuilder) -> {
//            Join<Product, Branch> product = root.join("product");
//            List<Predicate> predicates = new ArrayList<>();
//            if (productName != null){
//                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + productName.toLowerCase() + "%"));
//            }
//            if (productCode != null){
//                predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("productCode")), "%" + productCode.toLowerCase() + "%"));
//            }
//            if (maxPrice != null){
//                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
//            }
//            if (minPrice != null){
//                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
//            }
//            return query.where(predicates.toArray(new Predicate[]{})).getRestriction();
//        };
//        Pageable pageable = PageRequest.of(page, size);
//        Page<Product> products = productRepository.findAll(specification, pageable);
//        BranchResponse branch = products.get().get;
//        List<ProductResponse> productResponses = products.getContent().stream()
//                .map((ProductRequest product) -> toProductResponse(product, true))
//                .collect(Collectors.toList());
//
//
//        for (Product product : products.getContent()){
//            Product productPrice = product.getProductPriceId()
//                    .;
//            productResponses.add(product, productPrice, branch);
//        }
//        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
//    }
//
////    @Override
////    public ProductResponse update(ProductRequest request) {
////        ProductRequest productRequest = get(request.getProductId());
////        if (productRequest != null){
////            Product product = productRepository.save(request);
////            return toProductResponse(product);
////        }
////        return null;
////    }
//
//    @Override
//    public void deleteById(String id) {
//        productRepository.deleteById(id);
//    }

}
