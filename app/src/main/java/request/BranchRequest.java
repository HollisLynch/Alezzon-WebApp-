package request;

public class BranchRequest {
    private Long id;
    private String name;
    private String editBranch;

    public BranchRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BranchRequest(String name) {
        this.name = name;
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

    public BranchRequest() {
    }

    public String getEditBranch() {
        return editBranch;
    }

    public void setEditBranch(String editBranch) {
        this.editBranch = editBranch;
    }
}
