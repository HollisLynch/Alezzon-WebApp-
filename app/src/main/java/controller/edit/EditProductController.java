package controller.edit;

import controller.Retriever;
import request.edit.EditPictureRequest;
import request.edit.EditProductRequest;
import service.EditProductService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class EditProductController implements Serializable {

    private EditProductRequest editProductRequest;


    @Inject
    private EditProductService editProductService;

    @Inject
    private Retriever retriever;

    private EditPictureRequest editPictureRequest;


    public EditProductRequest getEditRequest() {
        if (editProductRequest == null) {
            editProductRequest = createEditRequest();
        }
        return editProductRequest;
    }


    private EditProductRequest createEditRequest() {
        if (retriever.contains("productId")) {

        }
        return new EditProductRequest();
    }



    public String save() {

        return "/productList.xhtml?faces-redirect=true";
    }

}
