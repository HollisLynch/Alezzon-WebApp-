package request;

import model.ProductParametr;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProductParamRequest {

    private Long product;
    private Long parameter;
    private String value;

    public Long getProduct() {
        return product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    public Long getParameter() {
        return parameter;
    }

    public void setParameter(Long parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductParamRequest() {
    }

    public ProductParamRequest(Long product, Long parameter, String value) {
        this.product = product;
        this.parameter = parameter;
        this.value = value;
    }
}
