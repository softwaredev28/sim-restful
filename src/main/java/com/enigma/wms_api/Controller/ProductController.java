package com.enigma.wms_api.Controller;

import com.enigma.wms_api.Model.ModelRequest.ProductRequest;
import com.enigma.wms_api.Model.ModelResponse.CommonResponse;
import com.enigma.wms_api.Model.ModelResponse.ProductResponse;
import com.enigma.wms_api.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request){
        ProductResponse productResponse = productService.createProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<ProductResponse>builder()
                        .data(productResponse)
                        .build());
    }

//    @GetMapping
//    public ResponseEntity<?> getAllProduct(
//            @RequestParam(name = "name", required = false) String name,
//            @RequestParam(name = "maxPrice", required = false) Long maxPrice,
//            @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
//            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size
//    ){
//        Page<ProductResponse> productResponses = productService.getAll(name, maxPrice, page, size);
//        PagingResponse pagingResponse = PagingResponse.builder()
//                .currentPage(page)
//                .totalPage(productResponses.getTotalPages())
//                .size(size)
//                .build();
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(CommonResponse.builder()
//                        .statusCode(HttpStatus.OK.value())
//                        .message("Successfully get all customer")
//                        .data(productResponses.getContent())
//                        .paging(pagingResponse)
//                        .build());
//    }
}
