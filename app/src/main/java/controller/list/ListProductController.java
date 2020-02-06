package controller.list;

import controller.Retriever;
import model.Picture;
import model.Product;
import model.ProductParametr;
import repository.ProductRepository;
import service.ParamService;
import service.ProductListService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
@RequestScoped
public class ListProductController {

    @Inject
    ProductRepository productRepository;

    @Inject
    ProductListService productListService;

    @Inject
    ParamService paramService;

    @Inject
    Retriever retriever;


    public Long getOwnerId() {

        Long ownerid = retriever.getLongUserId("id");
        return ownerid;
    }

    public List<Product> getProductListByOwnerId() {

        Long ownerId = getOwnerId();
        return paramService.getProductListByOwnerId(ownerId);

    }

    public List<Product> getProductListForUser() {

            Long ownerId = retriever.getLongUserId("id");
            return productRepository.getProductListByOwnerId(ownerId);

    }

    public Product getProduct() {
        Long productId = retriever.getLong("productId");
        return productRepository.getProductById(productId);
    }

    public List<ProductParametr> getParamByProductId(Long productId) {
        return productListService.getParameterByProductId(productId);
    }

    public List<Picture> getPicListByProductId(Long productId) {


        return productListService.getPicListByProductId(productId);
    }

    public List<Picture> getFirstPicByProductId(Long productId) {


        return productListService.getFirstPicByProductId(productId);
    }



}
