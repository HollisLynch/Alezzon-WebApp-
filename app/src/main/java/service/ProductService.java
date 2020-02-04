package service;


import model.Category;
import model.Product;
import repository.BranchRepository;
import repository.CategoryRepository;
import repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    private CategoryRepository categoryRepository;
    @Inject
    private BranchRepository branchRepository;
    @Inject
    private ProductRepository productRepository;

    public List<Category> findCategoryByBranchId(Long bId){
        return categoryRepository.findCategoryByBranchId(bId);
    }

    public List<Category> getCategoryList(){
        return categoryRepository.getCategoryList();
    }

    public List<Product> getProductListByOwnerId(Long ownerId){
        return productRepository.getProductListByOwnerId(ownerId);

    }
    public void save(Product product) {
        productRepository.save(product);
    }

    public Optional<Category> findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

}
