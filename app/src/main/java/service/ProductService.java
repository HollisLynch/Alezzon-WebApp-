package service;


import model.Category;
import model.Picture;
import model.Product;
import model.ProductParametr;
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
    private ProductRepository productRepository;


    public List<Category> getCategoryList(){
        return categoryRepository.getCategoryList();
    }

    public List<Product> getProductListByOwnerId(Long ownerId){
        return productRepository.getProductListByOwnerId(ownerId);

    }
    public void save(Product product) {
        productRepository.save(product);
    }

    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findCategoryById(categoryId);
    }

    public Product getProductById(Long productId) {
        return productRepository.getProductById(productId);
    }

    public void saveParametersToProduct(ProductParametr productParametr) {
        productRepository.saveParametersToProduct(productParametr);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void savePicToProduct(Picture picture) {
        productRepository.savePicToProduct(picture);
    }
}
