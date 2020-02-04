package controller.edit;


import controller.Retriever;
import model.Picture;
import model.Product;
import model.ProductParametr;
import request.edit.EditPictureRequest;
import request.edit.EditProductRequest;
import service.EditProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class EditProductController implements Serializable {

    private EditProductRequest editProductRequest;

    private boolean editmode;

    @Inject
    private EditProductService editProductService;

    @Inject
    private Retriever retriever;

    private EditPictureRequest editPictureRequest;


    public EditProductRequest getEditRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditProductRequest();
        }
        return editProductRequest;
    }

    public EditPictureRequest getEditPhotoRequest() {
        if (editPictureRequest == null) {
            editPictureRequest = new EditPictureRequest();
        }
        return editPictureRequest;
    }


    private EditProductRequest createEditProductRequest() {
        if (retriever.contains("productId")) {
            var productId = retriever.getLong("productId");

            var product = editProductService.findProductById(productId).orElseThrow();

            var category = editProductService.findCategoryByProductId(productId);

            List<ProductParametr> productParameters = editProductService.getParameterByProductId(productId);
            List<Picture> photos = editProductService.getPhotoListByProductId(productId);
            return new EditProductRequest(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), category,
                    product.getUser(), photos, productParameters);
        }
        return new EditProductRequest();
    }

    public EditPictureRequest getEditPicRequest() {
        if (editPictureRequest == null) {
            editPictureRequest = new EditPictureRequest();
        }
        return editPictureRequest;
    }

    public List<Picture> getPhotoListByProductId() {
        if (getEditRequest().getId() != null) {
            Long productId = editProductRequest.getId();
            return editProductService.getPhotoListByProductId(productId);
        }
        return editProductService.getPhotoListByProductId(49l);
    }


    public Long getCategoryId() {
        Long catid = retriever.getLong("id");
        return catid;
    }


    public String save() {
//        editmode = false;

//        var category = editProductService.findCategoryById(getCategoryId());


        Long ownerId = retriever.getLongUserId("id");
        editProductRequest.setUser(ownerId);

        Product p = editProductService.findProductById1(ownerId);



   //     p.setCategory(editProductRequest.getCategory());
//        p.setTitle(editProductRequest.getTitle());
//        p.setDescription(editProductRequest.getDescription());
//        p.setPrice(editProductRequest.getPrice());

        editProductService.save(p);



        return "/productList.xhtml?faces-redirect=true";
    }

    public boolean isEditmode() {
        return editmode;
    }

    public String edit() {
       // editmode = true;
        return "/editProduct.xhtml?faces-redirect=true";
    }
}
