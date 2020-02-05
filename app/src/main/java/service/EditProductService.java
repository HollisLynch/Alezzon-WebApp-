package service;


import model.*;
import repository.ParamRepository;
import repository.PictureRepository;
import repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class EditProductService {


    @Inject
    private ProductRepository productRepository;

    @Inject
    private ParamRepository paramRepository;

    @Inject
    private PictureRepository pictureRepository;

    public List<Product> getProductListByOwnerId(Long ownerId) {
        return productRepository.getProductListByOwnerId(ownerId);

    }

    public void save(Product product) {

        productRepository.save(product);

    }


    public List<Picture> getPhotoListByProductId(Long productId) {
        return pictureRepository.getPicListByProductId(productId);
    }

    public List<ProductParametr> getParameterByProductId(Long productId) {
        return paramRepository.getParamByProductId(productId);
    }

    public Category findCategoryByProductId(Long productId){
        return productRepository.findCategoryByProductId(productId);
    }


    public Product findProductById1(Long productId) {
        return productRepository.findProductById1(productId);
    }



}
