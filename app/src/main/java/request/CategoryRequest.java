package request;

import model.Branch;
import repository.BranchRepository;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

public class CategoryRequest implements Serializable {

    private Long id;
    private String name;
    private Long branchId;

    private BranchRepository br;

    List<Branch> branches;

    public List<Branch> getBranches() {
        return br.findAll();
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }




    public CategoryRequest(String name, Long branchId) {
        this.name = name;
        this.branchId = branchId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public CategoryRequest() {
    }

    public Branch getBranchId(Long valueOf) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Branch branch : getBranches()){
            if (id.equals(branch.getId())){
                return branch;
            }
        }
        return null;
    }

}
