package com.enigma.wms_api.Service;


import com.enigma.wms_api.Entity.Branch;

import java.util.List;

public interface BranchService {

    Branch create(Branch branch);
    Branch getById(String id);
    List<Branch> getAll();
    Branch update(Branch branch);
    void deleteById(String id);

}
