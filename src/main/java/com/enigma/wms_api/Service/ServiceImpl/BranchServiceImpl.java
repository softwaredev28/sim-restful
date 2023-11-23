package com.enigma.wms_api.Service.ServiceImpl;

import com.enigma.wms_api.Entity.Branch;
import com.enigma.wms_api.Model.ModelResponse.CommonResponse;
import com.enigma.wms_api.Repository.BranchRepository;
import com.enigma.wms_api.Service.BranchService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchService branchService;
    private final BranchRepository branchRepository;
    private Branch toBranchResponse(Branch branch){
        return Branch.builder()
                .id(branch.getId())
                .address(branch.getAddress())
                .branchCode(branch.getBranchCode())
                .name(branch.getName())
                .phoneNumber(branch.getPhoneNumber())
                .build();
    }
    @Override
    public Branch create(Branch request) {
        Branch branch = branchRepository.save(request);
        return toBranchResponse(branch);
    }

    @Override
    public Branch getById(String id) {
        Branch branch = branchRepository.findById(id).get();
        return toBranchResponse(branch);
    }

    @Override
    public List<Branch> getAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch update(Branch request) {
        Branch currentBranch = getById(request.getId());
        if (currentBranch != null){
            Branch branch = branchRepository.save(request);
            return toBranchResponse(branch);
        }
        return null;
    }

    @Override
    public void deleteById(String id) {
        branchRepository.deleteById(id);
    }

}
