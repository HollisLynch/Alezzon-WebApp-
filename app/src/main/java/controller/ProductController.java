package controller;


import controller.converters.Retriever;
import model.Category;
import model.Parametr;
import model.Product;
import model.ProductParametr;
import request.ProductRequest;
import service.ParamService;
import service.ProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;


@Named
@RequestScoped
public class ProductController {


    ProductRequest productRequest;

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

}
