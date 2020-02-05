package controller;

import request.CategoryRequest;
import service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class CategoryController implements Serializable {


   private CategoryRequest addCategoryRequest;

   @Inject
   private Retriever retriever;

   @Inject
   CategoryService categoryService;


    public CategoryRequest getAddRequest() {
        if (addCategoryRequest == null) {
            addCategoryRequest = new CategoryRequest();
        }
        return addCategoryRequest;
    }

     public String save() {

             return "/admin.xhtml?faces-redirect=true";

     }

}



