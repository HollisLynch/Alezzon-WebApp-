package controller.list;

import controller.converters.Retriever;
import model.Parametr;
import model.Picture;
import model.Product;
import model.ProductParametr;
import repository.ParamRepository;
import repository.ProductRepository;
import repository.ListRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListController {

    @Inject
    ProductRepository productRepository;

    @Inject
    ListRepository listRepository;

    @Inject
    ParamRepository paramRepository;

    @Inject
    Retriever retriever;


    public List<Product> findProductListForUser() {

            Long ownerId = retriever.getLongUserId("id");
            return productRepository.findProductListByOwnerId(ownerId);

    }

    public Product findProduct() {
        Long productId = retriever.getLong("productId");
        return productRepository.findProductById(productId);
    }

    public List<ProductParametr> findParamByProductId(Long productId) {
        return listRepository.findParameterByProductId(productId);
    }

    public List<Picture> findPicListByProductId(Long productId) {


        return listRepository.findPicListByProductId(productId);
    }

    public List<Picture> findFirstPicByProductId(Long productId) {


        return listRepository.findFirstPicByProductId(productId);
    }


    public boolean getGetEmptyList() {
        Long ownerId = retriever.getLongUserId("id");
        List<Product> listProduct = productRepository.findProductListByOwnerId(ownerId);
        if(listProduct.isEmpty()) {
            return true;
        }
        return false;
    }

    public List<ProductParametr> findParamListForProduct(Long productId) {
        return paramRepository.findParamListForProduct(productId);
    }
}
