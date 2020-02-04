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

         Long branchId = addCategoryRequest.getBranchId();
         String categoryName = addCategoryRequest.getName();

         if(!categoryService.doesCategoryExist(categoryName,branchId)){
            var section = categoryService.findBranchById(addCategoryRequest.getBranchId()).orElseThrow();
            categoryService.save(new Category(addCategoryRequest.getId(), addCategoryRequest.getName(), section));

             var branch = categoryService.findBranchById(branchId).orElseThrow();
             categoryService.save(new Category(addCategoryRequest.getId(), categoryName, branch));

             return "/admin.xhtml?faces-redirect=true";
         } else{
             FacesContext.getCurrentInstance().getExternalContext().getFlash()
                     .put("error-message", "Category exist in the Section");
             return "/admin.xhtml?faces-redirect=true";
         }
     }

     public List<Category> getAllCategory() {
        return categoryService.findAll();
     }

}



