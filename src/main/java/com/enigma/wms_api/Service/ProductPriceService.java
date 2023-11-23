package com.enigma.wms_api.Service;

import com.enigma.wms_api.Entity.ProductPrice;

public interface ProductPriceService {

    ProductPrice create(ProductPrice productPrice);
    ProductPrice getById(String id);
    ProductPrice findProductPriceActive(String productId, Boolean active);
}
