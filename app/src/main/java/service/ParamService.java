package service;


import model.Parametr;
import model.Product;
import model.ProductParametr;
import repository.ParamRepository;
import repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ParamService {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private ParamRepository paramRepository;

    public List<Product> getProductListByOwnerId(Long ownerId) {
        return productRepository.getProductListByOwnerId(ownerId);
    }

    public List<Parametr> getParamList() {
        return paramRepository.getParamList();
    }

    public void save(Parametr parameter) {
        paramRepository.save(parameter);
    }

    public void saveProductParam(ProductParametr parameter) {
        paramRepository.saveProductParam(parameter);
    }

    public Product findProductById(Long productId) {
        return productRepository.findProductById1(productId);
    }

    public Optional<Parametr> findParamById(Long parameterId) {
        return paramRepository.findParamById(parameterId);
    }

    public boolean doesParamExist(String parameterName) {
        try {
            Parametr param = paramRepository.findParamByName(parameterName);
            if (param.getValue().equals(parameterName))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("Parameter does not exist");
            return false;
        }
    }

    public boolean doesProductParamExist(String valueParam, Long parameterId, Long productId) {
        try {
            ProductParametr prodParameter = paramRepository.findProductParamByIdByName(valueParam,parameterId,productId);

            if (prodParameter.getValue().equals(valueParam))
                return true;
            return false;
        } catch (NoResultException nre) {
            System.out.println("Value of Parameter does not exist");
            return false;
        }
    }


}
