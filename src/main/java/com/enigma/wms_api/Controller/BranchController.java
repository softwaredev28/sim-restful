package com.enigma.wms_api.Controller;

import com.enigma.wms_api.Entity.Branch;
import com.enigma.wms_api.Model.ModelResponse.CommonResponse;
import com.enigma.wms_api.Service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/branch")
public class BranchController {

    private final BranchService branchService;

    @PostMapping
    public ResponseEntity<?> createBranch(@RequestBody Branch branch){
        Branch branchResponse = branchService.create(branch);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.<Branch>builder()
                        .data(branchResponse)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Branch>> getBranchById(@PathVariable String id){
        Branch branchResponse = branchService.getById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Branch>builder()
                        .data(branchResponse)
                        .build());
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<Branch>>> getAllBranch(){
        List<Branch> branches = branchService.getAll();

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<List<Branch>>builder()
                        .data(branches)
                        .build());
    }

    @PutMapping
    public ResponseEntity<?> updateBranch(@RequestBody Branch branch){
        Branch branchResponse = branchService.update(branch);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Branch>builder()
                        .data(branchResponse)
                        .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBranch(@PathVariable String id){
        branchService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.<Branch>builder()
                        .build());
    }

}
