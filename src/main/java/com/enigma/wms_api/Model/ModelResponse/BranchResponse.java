package com.enigma.wms_api.Model.ModelResponse;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BranchResponse {
    private String id;
    private String branchCode;
    private String name;
    private String address;
    private String phoneNumber;
}
