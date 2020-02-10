package service;


import model.Picture;
import model.Product;
import repository.PictureRepository;
import repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PictureService {

    @Inject
    private PictureRepository pictureRepository;

    @Inject
    private ProductRepository productRepository;


    public void save(Picture pic) {
        pictureRepository.save(pic);
    }

}
