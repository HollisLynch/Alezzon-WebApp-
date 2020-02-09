package controller;


import controller.converters.Retriever;
import model.*;
import request.ProductRequest;
import request.edit.EditProductRequest;
import service.ParamService;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Map;


@Named
@RequestScoped
public class ProductController implements Serializable {



    ProductRequest productRequest;

    @Inject
    EditProductRequest editProductRequest;

    @Inject
    private Retriever retriever;

    @Inject
    ProductService productService;

    @Inject
    ParamService paramService;


    public ProductRequest getAddRequest() {
        if (productRequest == null) {
            productRequest = createAddRequest();
        }
        return productRequest;
    }


    public ProductRequest createAddRequest() {
        ProductRequest p = new ProductRequest();
        return p;
    }

    public ProductRequest getEditRequest() {
        if (productRequest == null) {
            productRequest = createEditRequest();
        }
        return productRequest;
    }


    public ProductRequest createEditRequest() {
        ProductRequest p = new ProductRequest();
        return p;
    }



    public String save() {

        String title = productRequest.getTitle();
        String description = productRequest.getDescription();
        double price = productRequest.getPrice();

        Product product = new Product();

        Category category;
        category = productService.findCategoryById(productRequest.getCategoryId());
        product.setCategory(category);

        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        Long user = retriever.getLongUserId("id");
        product.setUser(user);


        productService.save(product);
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public String saveParametersToProduct() {
        String value = productRequest.getValue();
        Long parametrId = productRequest.getParameterId();
        Long productId = productRequest.getId();

        Product p = productService.getProductById(productId);
        Parametr parametr = paramService.findParamById(parametrId);

        ProductParametr productParametr = new ProductParametr();

        productParametr.setProduct(p);
        productParametr.setParameter(parametr);
        productParametr.setValue(value);

        productService.saveParametersToProduct(productParametr);
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public String savePicToProduct() {
        String link = productRequest.getLink();
        Long productId = productRequest.getId();

        Product p = productService.getProductById(productId);

        Picture picture = new Picture();

        picture.setProduct(p);
        picture.setLink(link);

        productService.savePicToProduct(picture);
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public List<Product> getProductList() {

        return productService.findAll();
    }

    public List<Product> getProductListByOwnerId() {
        Long user = retriever.getLongUserId("id");
        return productService.getProductListByOwnerId(user);
    }

    public Product getProductById() {
        Long productId = productRequest.getId();
        return productService.getProductById(productId);
    }

    public String edit() {

        FacesContext fc = FacesContext.getCurrentInstance();

        Map<String,String> params =
                fc.getExternalContext().getRequestParameterMap();

        String idStr = params.get("id");

       Long id = Long.parseLong(idStr);
       Product product=productService.getProductById(id);
        editProductRequest.setId(product.getId());
        editProductRequest.setDescription(product.getDescription());
        editProductRequest.setTitle(product.getTitle());
        editProductRequest.setPrice(product.getPrice());


        return "/editProduct.xhtml?faces-redirect=true";
    }

    public String editProduct() {


        Long id = productRequest.getId();

        String oldTitle = productRequest.getTitle();
        String oldDescription = productRequest.getDescription();
        double oldPrice = productRequest.getPrice();


        return "/editProduct.xhtml?faces-redirect=true";
    }

}
