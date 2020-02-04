package controller;


import model.Branch;
import repository.BranchRepository;
import request.edit.EditBranchRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.io.Serializable;
import java.util.List;

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
        if (retriever.contains("branchId")) {
            var branchId = retriever.getLong("branchId");
            var branch = branchRepository.findBranchById(branchId).orElseThrow();  //TODO
            return new EditBranchRequest(branch);
        }
        return new EditBranchRequest();
    }

    public boolean doesBranchExist() {
        try {
            String branchName = editBranchRequest.getName().trim();
            Branch branch = branchRepository.findBranchByName(branchName);
            if (branch.getName().equals(branchName))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("section does not exist");
            return false;
        }
    }

    public String save() {
        if (!doesBranchExist()) {
            var branch = editBranchRequest.toBranch();
            branchRepository.save(branch);
            return "/admin.xhtml?faces-redirect=true";
        }
        else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Section exist");
            return "/admin.xhtml?faces-redirect=true";
        }

    }

}























