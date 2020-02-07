package controller;


import controller.converters.Retriever;
import request.add.AddProductRequest;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


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


    public String save() {

        return "/addProduct.xhtml?faces-redirect=true";
    }

}
