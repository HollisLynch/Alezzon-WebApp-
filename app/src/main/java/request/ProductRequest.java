package request;

import model.ProductParametr;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;



public class ProductRequest {

    private Long id;
    private Long editId;
    private Long categoryId;
    private Long userId;
    private String title;
    private String description;
    private String link;
    private List<ProductParametr> parameters;
    private String value;
    private boolean editmode;

    private double price;

    private Long parameterId;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ProductRequest() {
    }

    public boolean isEditmode() {
        return editmode;
    }

    public void setEditmode(boolean editmode) {
        this.editmode = editmode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductParametr> getParameters() {
        return parameters;
    }

    public void setParameters(List<ProductParametr> parameters) {
        this.parameters = parameters;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getParameterId() {
        return parameterId;
    }

    public void setParameterId(Long parameterId) {
        this.parameterId = parameterId;
    }

    public Long getEditId() {
        return editId;
    }

    public void setEditId(Long editId) {
        this.editId = editId;
    }
}
