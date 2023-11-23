package com.enigma.wms_api.Repository;

import com.enigma.wms_api.Entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, String> {
    Optional<ProductPrice> findByProduct_IdAndIsActive(String productId, Boolean active);

}
