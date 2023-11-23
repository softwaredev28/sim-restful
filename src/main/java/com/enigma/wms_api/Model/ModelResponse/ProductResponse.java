package com.enigma.wms_api.Model.ModelResponse;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ProductResponse {
    private String productId;
    private String productPriceId;
    private String productCode;
    private String productName;
    private Long price;
    private BranchResponse branch;

//    @JsonProperty("productPriceId")
//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    public String getTotalSalesForResponse(){
//        return productPriceId;
//    }
}
