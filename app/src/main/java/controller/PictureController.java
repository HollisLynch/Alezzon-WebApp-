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

    public Long getOwnerId() {
        Long ownerid = retriever.getLongUserId("id");
        return ownerid;
    }

    public AddPictureRequest getAddPhotoRequest() {
        if (addPictureRequest == null) {
            addPictureRequest = new AddPictureRequest();
        }
        return addPictureRequest;
    }

    public List<Product> getProductListByOwnerId(){
        Long ownerId = getOwnerId();
        return pictureService.getProductListByOwnerId(ownerId);
    }

    public String save() {
        var product = pictureService.findProductById(addPictureRequest.getProductId()).orElseThrow();
        pictureService.save(new Picture(product,addPictureRequest.getLink()));
        return "/addPictures.xhtml?faces-redirect=true";
    }
}
