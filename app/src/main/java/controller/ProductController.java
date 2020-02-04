package controller;


import model.Category;
import model.Product;
import request.add.AddProductRequest;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
@RequestScoped
public class ProductController {


    AddProductRequest addProductRequest;

    @Inject
    private Retriever retriever;


    @Inject
    ProductService productService;


    public AddProductRequest getAddRequest() {
        if (addProductRequest == null) {
            addProductRequest = new AddProductRequest();
        }
        return addProductRequest;
    }

    public List<Category> getCategoryList() {
        if (getAddRequest().getCategoryId() != null) {
            return productService.getCategoryList();
        }
        return productService.getCategoryList();

    }


    public List<Product> getProductListByOwnerId() {
        Long ownerId = getOwnerId();
        return productService.getProductListByOwnerId(ownerId);
    }




    public Long getOwnerId() {
        Long ownerId = retriever.getLongUserId("id");
        addProductRequest.setUserId(ownerId);
        return addProductRequest.getUserId();
    }


    public String save() {

        var category = productService.findCategoryById(addProductRequest.getCategoryId()).orElseThrow();
        productService.save(new Product(category, addProductRequest.getTitle(),
                                        addProductRequest.getDescription(),
                                        addProductRequest.getPrice(),
                                        getOwnerId()));



        return "/addProduct.xhtml?faces-redirect=true";
    }

}
