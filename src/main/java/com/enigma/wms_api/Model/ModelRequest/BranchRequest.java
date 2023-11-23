package com.enigma.wms_api.Model.ModelRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BranchRequest {

    @NotBlank
    @Size(max = 255)
    private String branchCode;

    @NotBlank
    @Size(max = 255)
    private String branchName;

    @Size(max = 255)
    private String address;

    @Size(max = 255)
    private String phoneNumber;
}
