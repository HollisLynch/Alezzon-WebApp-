package service;

import model.Branch;
import model.Category;
import repository.BranchRepository;
import repository.CategoryRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryService {

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private BranchRepository branchRepository;

    public Optional<Branch> findBranchById(Long branchId) {
        return branchRepository.findBranchById(branchId);

    }

    public Optional<Category> findCategoryById(Long categoryId){
        return  categoryRepository.findCategoryById(categoryId);
    }


    public void save(Category category) {
        categoryRepository.save(category);
    }


    public List<Category> findAll(){
        return categoryRepository.findAll();
    }


    public Optional<Branch> getBranchFromCategory(Long categoryId){
        return categoryRepository.getBranchFromCategory(categoryId);
    }

    public boolean doesCategoryExist(String categoryName,Long branchId) {
        try {
            List<Category> categoryList = categoryRepository.findCategoryByBranchId(branchId);
            for (Category c:categoryList) {
                if(c.getName().equals(categoryName))
                    return true;
            }
            return false;
        } catch (NoResultException nre) {
            System.out.println("Category does not exist");
            return false;
        }
    }


}
