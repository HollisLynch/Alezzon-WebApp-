package model;

import javax.annotation.ManagedBean;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_parametr")
public class ProductParametr implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "parametr_id", nullable = false)
    private Parametr parameter;

    private String value;

    public ProductParametr() {
    }

    public ProductParametr(Product product, Parametr parameter, String value) { //TODO
        this.product = product;
        this.parameter = parameter;
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Parametr getParameter() {
        return parameter;
    }

    public void setParameter(Parametr parameter) {
        this.parameter = parameter;
    }

    public String getValue() {
        return value;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
