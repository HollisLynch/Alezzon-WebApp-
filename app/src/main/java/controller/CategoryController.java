package controller;


import model.Branch;
import model.Category;
import repository.BranchRepository;
import repository.CategoryRepository;
import request.add.AddCategoryRequest;
import service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;


@Named
@RequestScoped
public class CategoryController implements Serializable {


   private AddCategoryRequest addCategoryRequest;

   @Inject
   private Retriever retriever;

   @Inject
   CategoryService categoryService;


    public AddCategoryRequest getAddRequest() {
        if (addCategoryRequest == null) {
            addCategoryRequest = new AddCategoryRequest();
        }
        return addCategoryRequest;
    }

     public String save() {

             return "/admin.xhtml?faces-redirect=true";

     }

}



