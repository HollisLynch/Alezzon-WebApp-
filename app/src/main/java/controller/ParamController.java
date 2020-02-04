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
        if (retriever.contains("paramId")) {
            var paramId = retriever.getLong("paramId");
            var param = paramService.findParamById(paramId).orElseThrow();  //TODO
            return new AddParamRequest(param);
        }
        return new AddParamRequest();
    }

    public AddProductParamRequest getAddProductParameterRequest() {
        if (addProductParamRequest == null) {
            addProductParamRequest = new AddProductParamRequest();
        }
        return addProductParamRequest;
    }

    public String save() {

        String paramName = addParamRequest.getValue();
        if (!paramService.doesParamExist(paramName)) {
            paramService.save(new Parametr(paramName));

            return "/addParameter.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Parameter exists");
            return "/addParameter.xhtml?faces-redirect=true";
        }
    }

    public String saveProductParam() {

        var product = paramService.findProductById(addProductParamRequest.getProduct()).orElseThrow();
        var parameter = paramService.findParamById(addProductParamRequest.getParameter()).orElseThrow();
        String valueParam = addProductParamRequest.getValue().trim();
        Long parameterId = parameter.getId();
        Long productId = product.getId();

        if (!paramService.doesProductParamExist(valueParam,parameterId,productId)) {

            paramService.saveProductParam(new ProductParametr(product, parameter, valueParam));

            return "/addParameter.xhtml?faces-redirect=true";

        }

        else {

            FacesContext.getCurrentInstance().getExternalContext().getFlash()
                    .put("error-message", "Value already exists");
            return "/addParameter.xhtml?faces-redirect=true";

        }
    }

    public Long getOwnerId() {

        Long ownerid = retriever.getLongUserId("id");
        return ownerid;
    }
    public List<Product> getProductListByOwnerId() {

        Long ownerId = getOwnerId();
        return paramService.getProductListByOwnerId(ownerId);

    }

    public List<Parametr> getParamList(){
        return paramService.getParamList();
    }

}
