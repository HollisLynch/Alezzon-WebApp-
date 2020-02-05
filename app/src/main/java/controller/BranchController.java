package controller;

import repository.BranchRepository;
import request.edit.EditBranchRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class BranchController{

    @Inject
    BranchRepository branchRepository;

    private EditBranchRequest editBranchRequest;

    @Inject
    private Retriever retriever;

    public EditBranchRequest getEditBranchRequest() {
        if (editBranchRequest == null) {
            editBranchRequest = createEditBranchRequest();
        }
        return editBranchRequest;
    }

    private EditBranchRequest createEditBranchRequest() {
        return null;
    }

    public String save() {

        return "/admin.xhtml?faces-redirect=true";

    }

}























