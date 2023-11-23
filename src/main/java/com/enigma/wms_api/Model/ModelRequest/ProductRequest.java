package com.enigma.wms_api.Model.ModelRequest;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ProductRequest {
    private String productId;

    @NotBlank(message = "product price id is required")
    private String productPriceId;

    @NotBlank(message = "product code is required")
    private String productCode;

    @NotBlank(message = "product name is required")
    private String productName;

    @NotNull(message = "price is required")
    @Min(value = 0, message = "price must be greater than equal 0")
    private Long price;

    @NotBlank(message = "Branch is required")
    private String branchId;
}
