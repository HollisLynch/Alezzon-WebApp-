package model;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "product")
public class Product implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;

    @Column(name = "name")
    private String title;

    private String description;

    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "product")
//    @OrderColumn(name = "order")
    private List<Picture> pictures;

    //  @OrderBy("parameter.name")
    //  @JoinColumn(name = "product_id", nullable = false)
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "product")
    private List<ProductParametr> parameters;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "owner_id", nullable = false)
    private Long user;

    public Product(Category category, String title, String description, double price, Long user) {
        this.category = category;
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public Product(String title, String description, double price, Long user) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.user = user;
    }

    public Product(String title, String description, double price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }


    public Product() {
    }





    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<ProductParametr> getParameters() {
        return parameters;
    }

    public void setParameters(List<ProductParametr> parameters) {
        this.parameters = parameters;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
