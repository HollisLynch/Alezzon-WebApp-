package controller;

import model.Branch;
import model.Category;
import repository.BranchRepository;
import repository.CategoryRepository;
import request.CategoryRequest;

import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.FacesException;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;


@Named
@RequestScoped
@ManagedBean("categoryController")
public class CategoryController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    CategoryRepository categoryRepository;

    @Inject
    BranchRepository branchRepository;

    @Inject
    private Retriever retriever;

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
        try
        {
            CategoryRequest cr = new CategoryRequest(getAddRequest().getName(), getAddRequest().getBranchId());

            Category cat = new Category(cr);
            categoryRepository.save(cat);
            return "/addBranch.xhtml?faces-redirect=true";

        } catch(Exception e)
        {

            throw new FacesException(e);


        }

    }

    public List<Category> getCategoryList() {

        return categoryRepository.findAll();
    }

    public List<Branch> getBranchList() {

        return branchRepository.findAll();
    }
}



