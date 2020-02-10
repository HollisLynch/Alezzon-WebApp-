package controller;

import controller.converters.Retriever;
import model.Branch;
import repository.BranchRepository;
import request.BranchRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class BranchController {

    private BranchRequest branchRequest;

    @Inject
    BranchRepository branchRepository;


    public BranchRequest getAddRequest() {
        if (branchRequest == null) {
            branchRequest = createBranchRequest();
        }
        return branchRequest;
    }

    private BranchRequest createBranchRequest() {
        BranchRequest br = new BranchRequest();
        return br;
    }

    public String save() {

        Branch br = new Branch(branchRequest.getName());
        branchRepository.save(br);
        return "/addCategory.xhtml?faces-redirect=true";

    }

    public String edit() {
        Branch oldBranch = branchRepository.findBranchById(branchRequest.getId());

        oldBranch.setName(branchRequest.getEditBranch());

        branchRepository.save(oldBranch);
        return "/editBranch.xhtml?faces-redirect=true";

    }

    public List<Branch> getBranchList() {

        return branchRepository.findAll();
    }

}























