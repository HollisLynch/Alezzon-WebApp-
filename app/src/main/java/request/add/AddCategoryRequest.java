package request.add;

import model.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


public class AddCategoryRequest {
    private Long id;
    private String name;
    private Long branchId;

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

    public AddCategoryRequest() {
    }

    public AddCategoryRequest(Long id, String name, Long branchId) {
        this.id = id;
        this.name = name;
        this.branchId = branchId;
    }

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }
}
