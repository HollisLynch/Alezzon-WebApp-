package controller;

import controller.converters.Retriever;
import model.Parametr;
import repository.ParamRepository;
import request.ParamRequest;
import request.ProductParamRequest;
import service.ParamService;

import javax.enterprise.context.RequestScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@ViewScoped
public class ParamController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    ParamService paramService;

    private ParamRequest paramRequest;

    public ParamRequest getAddParamRequest() {
        if (paramRequest == null) {
            paramRequest = createAddParamRequest();
        }
        return paramRequest;
    }

    private ParamRequest createAddParamRequest() {
        ParamRequest paramRequest = new ParamRequest();
        return paramRequest;
    }



    public String save() {


            String name = paramRequest.getValue();

            Parametr p = new Parametr();

            p.setValue(name);
            paramService.save(p);

            return "/addParameter.xhtml?faces-redirect=true";

    }

    public String saveProductParam() {


            return "/addParameter.xhtml?faces-redirect=true";



    }

    public List<Parametr> getParamList() {

        return paramService.findAll();
    }



}
