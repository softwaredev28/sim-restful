package com.enigma.wms_api.Service;

import com.enigma.wms_api.Model.ModelRequest.ProductRequest;
import com.enigma.wms_api.Model.ModelResponse.ProductResponse;

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);
//    Page<ProductResponse> getAll(Integer size, Integer page, String productCode, String productName, String minPrice, String maxPrice );

    //    ProductResponse getByBranchId(String id);
//    ProductResponse update(ProductRequest product);
    void deleteById(String id);

}
