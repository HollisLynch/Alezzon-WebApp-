package controller;


import model.Product;
import request.PictureRequest;
import service.PictureService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PictureController {

    @Inject
    PictureService pictureService;

    PictureRequest addPictureRequest;

    @Inject
    Retriever retriever;



    public PictureRequest getAddPhotoRequest() {
        if (addPictureRequest == null) {
            addPictureRequest = new PictureRequest();
        }
        return addPictureRequest;
    }

    public List<Product> getProductListByOwnerId(){


        return null;
    }

    public String save() {

        return "/addPictures.xhtml?faces-redirect=true";
    }
}
