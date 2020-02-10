package service;

import model.Parametr;
import model.Picture;
import model.Product;
import model.ProductParametr;
import repository.ParamRepository;
import repository.PictureRepository;
import repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductListService {

    @Inject
    private ProductRepository productRepository;

    @Inject
    private PictureRepository picRepository;

    @Inject
    private ParamRepository paramRepository;

    public List<Picture> getPicListByProductId(Long productId) {
        return picRepository.getPicListByProductId(productId);
    }

    public List<Picture> getFirstPicByProductId(Long productId) {
        return picRepository.getFirstPicByProductId(productId);
    }


    public List<ProductParametr> getParameterByProductId(Long productId) {
        return paramRepository.getParamByProductId(productId);
    }
}
