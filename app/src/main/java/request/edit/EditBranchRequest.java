package request.edit;



import model.Branch;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Optional;


public class EditBranchRequest {
    private Long id;
    private String name;


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

    public EditBranchRequest() {
    }
    public EditBranchRequest(Branch branch) {
        this.id = branch.getId();
        this.name = branch.getName();
    }

    public Branch toBranch() {
        return new Branch(id, name);
    }

}
