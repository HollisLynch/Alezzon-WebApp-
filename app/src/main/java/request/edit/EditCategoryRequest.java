package request.edit;


import model.Branch;
import model.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Optional;


public class EditCategoryRequest {
    private Long id;
    private String name;
    private Branch branchId;

    public EditCategoryRequest(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.branchId = category.getBranchId();
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

    public EditCategoryRequest() {

    }

    public EditCategoryRequest(Long id, String name, Branch branchId) {
        this.id = id;
        this.name = name;
        this.branchId = branchId;
    }

}













































