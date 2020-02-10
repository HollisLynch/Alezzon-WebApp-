package controller;


import controller.converters.Retriever;
import model.*;
import repository.CategoryRepository;
import repository.ParamRepository;
import repository.ProductRepository;
import request.ProductRequest;
import request.edit.EditProductRequest;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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
    ProductRepository productRepository;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    ParamRepository paramRepository;


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

    public EditProductRequest getEditRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditRequest();
        }
        return editProductRequest;
    }


    public EditProductRequest createEditRequest() {
        EditProductRequest p = new EditProductRequest();
        return p;
    }


    public String save() {

        String title = productRequest.getTitle();
        String description = productRequest.getDescription();
        double price = productRequest.getPrice();

        Product product = new Product();

        Category category;
        category = categoryRepository.findCategoryById(productRequest.getCategoryId());
        product.setCategory(category);

        product.setTitle(title);
        product.setDescription(description);
        product.setPrice(price);

        Long user = retriever.getLongUserId("id");
        product.setUser(user);


        productRepository.save(product);
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public String saveParametersToProduct() {
        String value = productRequest.getValue();
        Long parametrId = productRequest.getParameterId();
        Long productId = productRequest.getId();

        Product p = productRepository.findProductById(productId);
        Parametr parametr = paramRepository.findParamById(parametrId);

        ProductParametr productParametr = new ProductParametr();

        productParametr.setProduct(p);
        productParametr.setParameter(parametr);
        productParametr.setValue(value);

        productRepository.saveParametersToProduct(productParametr);
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public String savePicToProduct() {
        savePics(productRequest.getLink(), productRequest.getId());
        return "/addProduct.xhtml?faces-redirect=true";
    }

    public String addPicToProduct() {
        savePics(productRequest.getLink(), editProductRequest.getId());
        return "/editPictures.xhtml?faces-redirect=true";
    }

    private void savePics(String link2, Long id) {
        String link = link2;
        Long productId = id;

        Product p = productRepository.findProductById(productId);

        Picture picture = new Picture();

        picture.setProduct(p);
        picture.setLink(link);

        productRepository.savePicToProduct(picture);
    }


    public List<Product> getProductListByOwnerId() {
        Long user = retriever.getLongUserId("id");
        return productRepository.findProductListByOwnerId(user);
    }

    public String edit() {

        FacesContext fc = FacesContext.getCurrentInstance();

        Map<String, String> params =
                fc.getExternalContext().getRequestParameterMap();

        String idStr = params.get("id");

        Long id = Long.parseLong(idStr); // Product ID
        Product product = productRepository.findProductById(id); // Product

        editProductRequest.setId(id);
        String titleOld = product.getTitle();
        String desOld = product.getDescription();
        double priceOld = product.getPrice();
        Category category = product.getCategory();
        Long categoryId = category.getId();


        editProductRequest.setId(id);
        editProductRequest.setTitle(titleOld);
        editProductRequest.setDescription(desOld);
        editProductRequest.setPrice(priceOld);
        editProductRequest.setCategoryId(categoryId);



        return "/editProduct.xhtml?faces-redirect=true";
    }

    public String editProduct() {

        Product product = productRepository.findProductById(editProductRequest.getId());

        Long user = retriever.getLongUserId("id");
        product.setUser(user);

        String title = editProductRequest.getTitle();
        product.setTitle(title);

        String des = editProductRequest.getDescription();
        product.setDescription(des);

        double price = editProductRequest.getPrice();
        product.setPrice(price);

        Category category;
        category = categoryRepository.findCategoryById(editProductRequest.getCategoryId());
        product.setCategory(category);

        productRepository.save(product);

        return "/editProduct.xhtml?faces-redirect=true";
    }


    public String saveEditedParametersToProduct() {
        String valueNew = editProductRequest.getValue();
        Long parameterId = editProductRequest.getParameterId();
        Long productId = editProductRequest.getId();

     //   Product p = productRepository.findProductById(productId);
        Parametr parametr = paramRepository.findParamById(parameterId);
        ProductParametr productParametr = productRepository.findProductParamByParamIdAndProduct(parameterId, productId);


        productParametr.setParameter(parametr);
        productParametr.setValue(valueNew);

        productRepository.saveParametersToProduct(productParametr);
        return "/editParameters.xhtml?faces-redirect=true";
    }

    private boolean emptyRequestSend;

    public boolean getEmptyRequestSend() {
        if (editProductRequest.getId() == null) {
            return true;
        }
        return false;
    }

}
