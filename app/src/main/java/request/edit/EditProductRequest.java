package request.edit;

import model.Category;
import model.Picture;
import model.ProductParametr;
import java.util.List;


public class EditProductRequest {

    private List<Picture> pictures;
    private Long id;
    private Category category;
    private String picLink;
    private String title;
    private String description;
    private List<ProductParametr> productParametr;
    private double price;
    private Long user;
    private boolean editable;

    public EditProductRequest(List<Picture> pictures,
                              Long id, Category category,
                              String picLink, String title, String description,
                              List<ProductParametr> productParametr, double price,
                              Long user, boolean editable) {
        this.pictures = pictures;
        this.id = id;
        this.category = category;
        this.picLink = picLink;
        this.title = title;
        this.description = description;
        this.productParametr = productParametr;
        this.price = price;
        this.user = user;
        this.editable = editable;
    }




    public EditProductRequest() {
    }



    public EditProductRequest(Long id, String title,
                              String description, double price,
                              Category category, Long user, List<Picture> pictures,
                              List<ProductParametr> productParameters) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.user = user;
        this.pictures = pictures;
        this.productParametr = productParameters;

    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPicLink() {
        return picLink;
    }

    public void setPicLink(String picLink) {
        this.picLink = picLink;
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

    public List<ProductParametr> getProductParametr() {
        return productParametr;
    }

    public void setProductParametr(List<ProductParametr> productParametr) {
        this.productParametr = productParametr;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
