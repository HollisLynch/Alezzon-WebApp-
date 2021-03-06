package controller;

import model.Parametr;
import repository.ParamRepository;
import request.ParamRequest;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ParamController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    ParamRepository paramRepository;

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
        paramRepository.save(p);

        return "/addParameter.xhtml?faces-redirect=true";

    }


    public List<Parametr> getParamList() {

        return paramRepository.findAll();
    }


//    public List<Parametr> getGetParamListForProduct() {
//    }
}
