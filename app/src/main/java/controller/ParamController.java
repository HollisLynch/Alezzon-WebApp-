package controller;

import model.Branch;
import model.Parametr;
import model.Product;
import model.ProductParametr;
import repository.BranchRepository;
import repository.ParamRepository;
import request.add.AddParamRequest;
import request.add.AddProductParamRequest;
import request.edit.EditBranchRequest;
import service.ParamService;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.util.List;

@Named
@RequestScoped
public class ParamController {

    @Inject
    ParamService paramService;

    private AddParamRequest addParamRequest;

    private AddProductParamRequest addProductParamRequest;

    @Inject
    private Retriever retriever;

    public AddParamRequest getAddParamRequest() {
        if (addParamRequest == null) {
            addParamRequest = createAddParamRequest();
        }
        return addParamRequest;
    }

    private AddParamRequest createAddParamRequest() {
        return null;
    }

    public AddProductParamRequest getAddProductParameterRequest() {
        if (addProductParamRequest == null) {
            addProductParamRequest = new AddProductParamRequest();
        }
        return addProductParamRequest;
    }

    public String save() {


            return "/addParameter.xhtml?faces-redirect=true";

    }

    public String saveProductParam() {


            return "/addParameter.xhtml?faces-redirect=true";



    }



}
