package repository;

import model.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ListRepository {

    @Inject
    private PictureRepository picRepository;

    @Inject
    private ParamRepository paramRepository;
//
//    @Inject
//    private BranchRepository branchRepository;
//
//    @Inject
//    private CategoryRepository categoryRepository;

    public List<Picture> findPicListByProductId(Long productId) {
        return picRepository.findPicListByProductId(productId);
    }

    public List<Picture> findFirstPicByProductId(Long productId) {
        return picRepository.findFirstPicByProductId(productId);
    }


    public List<ProductParametr> findParameterByProductId(Long productId) {
        return paramRepository.findParamByProductId(productId);
    }

}
