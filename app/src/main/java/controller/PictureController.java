package controller;


import model.Picture;
import model.Product;
import request.add.AddPictureRequest;
import service.PictureService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PictureController {

    @Inject
    PictureService pictureService;

    AddPictureRequest addPictureRequest;

    @Inject
    Retriever retriever;



    public AddPictureRequest getAddPhotoRequest() {
        if (addPictureRequest == null) {
            addPictureRequest = new AddPictureRequest();
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
