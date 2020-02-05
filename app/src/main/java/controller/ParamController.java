package controller;

import request.ParamRequest;
import request.add.AddProductParamRequest;
import service.ParamService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class ParamController {

    @Inject
    ParamService paramService;

    private ParamRequest addParamRequest;

    private AddProductParamRequest addProductParamRequest;

    @Inject
    private Retriever retriever;

    public ParamRequest getAddParamRequest() {
        if (addParamRequest == null) {
            addParamRequest = createAddParamRequest();
        }
        return addParamRequest;
    }

    private ParamRequest createAddParamRequest() {
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
