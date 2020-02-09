package controller;

import controller.converters.BranchConverter;
import controller.converters.Retriever;
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

    public List<Category> getCategoryList() {

        return categoryRepository.findAll();
    }

    public List<Branch> getBranchList() {

        return branchRepository.findAll();
    }
}



