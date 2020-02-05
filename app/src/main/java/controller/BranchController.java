package controller;

import repository.BranchRepository;
import request.BranchRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class BranchController{

    @Inject
    BranchRepository branchRepository;

    private BranchRequest editBranchRequest;

    @Inject
    private Retriever retriever;

    public BranchRequest getEditBranchRequest() {
        if (editBranchRequest == null) {
            editBranchRequest = createEditBranchRequest();
        }
        return editBranchRequest;
    }

    private BranchRequest createEditBranchRequest() {
        return null;
    }

    public String save() {

        return "/admin.xhtml?faces-redirect=true";

    }

}























