package controller;

import model.Branch;
import model.Category;
import repository.BranchRepository;
import repository.CategoryRepository;
import request.CategoryRequest;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@ViewScoped
public class CategoryController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    BranchRepository branchRepository;

    private CategoryRequest categoryRequest;

    public CategoryRequest getAddRequest() {
        if (categoryRequest == null) {
            categoryRequest = createRequest();
        }
        return categoryRequest;
    }

    private CategoryRequest createRequest() {
        CategoryRequest cr = new CategoryRequest();
        return cr;
    }

    public String saveCategory() {

        Long branchId = categoryRequest.getBranchId();

        Branch branch = branchRepository.findBranchById(branchId);

        String name = categoryRequest.getName();

        Category cat = new Category();

        cat.setName(name);
        cat.setBranch(branch);

        categoryRepository.save(cat);

        return "/addParameter.xhtml?faces-redirect=true";

    }

    public String edit() {
        Category oldCategory = categoryRepository.findCategoryById(categoryRequest.getId());

        oldCategory.setName(categoryRequest.getEditCategory());

        categoryRepository.save(oldCategory);
        return "/editCategory.xhtml?faces-redirect=true";

    }

    public List<Category> findCategoryList() {

        return categoryRepository.findAll();
    }

    public List<Branch> findBranchList() {

        return branchRepository.findAll();
    }

    public boolean getIsEmptyList() {
        if(findCategoryList().isEmpty()) {
            return true;
        }
        return false;
    }
}



