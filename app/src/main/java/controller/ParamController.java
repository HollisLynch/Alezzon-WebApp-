package controller;

import controller.converters.Retriever;
import request.ParamRequest;
import request.ProductParamRequest;
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

    private ProductParamRequest productParamRequest;

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

    public ProductParamRequest getAddProductParameterRequest() {
        if (productParamRequest == null) {
            productParamRequest = new ProductParamRequest();
        }
        return productParamRequest;
    }

    public String save() {


            return "/addParameter.xhtml?faces-redirect=true";

    }

    public String saveProductParam() {


            return "/addParameter.xhtml?faces-redirect=true";



    }



}
