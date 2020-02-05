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

    private BranchRequest branchRequest;

    @Inject
    private Retriever retriever;

    public BranchRequest getEditBranchRequest() {
        if (branchRequest == null) {
            branchRequest = createEditBranchRequest();
        }
        return branchRequest;
    }

    private BranchRequest createEditBranchRequest() {
        return null;
    }

    public String save() {


        return "/admin.xhtml?faces-redirect=true";

    }

}























