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




}
