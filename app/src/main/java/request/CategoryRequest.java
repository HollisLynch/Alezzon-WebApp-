package request;

import model.Branch;

public class CategoryRequest {

    private Long id;
    private String name;
    private Branch branchId;

    public CategoryRequest(Long id, String name, Branch branchId) {
        this.id = id;
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

    public Branch getBranchId() {
        return branchId;
    }

    public void setBranchId(Branch branchId) {
        this.branchId = branchId;
    }
}
