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

@ApplicationScoped
public class ParamService {

    @Inject
    private ProductRepository productRepository;
    @Inject
    private ParamRepository paramRepository;

    public List<Parametr> findAll() {
        return paramRepository.findAll();
    }

    public void save(Parametr parameter) {
        paramRepository.save(parameter);
    }

    public Parametr findParamById(Long parameterId) {
        return paramRepository.findParamById(parameterId);
    }

}
