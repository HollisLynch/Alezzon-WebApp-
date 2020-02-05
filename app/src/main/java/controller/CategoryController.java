package controller;

import request.CategoryRequest;
import service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@RequestScoped
public class CategoryController {


   private CategoryRequest categoryRequest;

   @Inject
   private Retriever retriever;

   @Inject
   CategoryService categoryService;


    public CategoryRequest getAddRequest() {
        if (categoryRequest == null) {
            categoryRequest = new CategoryRequest();
        }
        return categoryRequest;
    }

    private CategoryRequest createAddRequest() {
        return null;
    }

     public String save() {

             return "/admin.xhtml?faces-redirect=true";

     }

}



