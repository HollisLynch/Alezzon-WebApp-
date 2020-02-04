package controller.edit;

import controller.Retriever;
import model.Category;
import request.edit.EditCategoryRequest;
import service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditCategoryController {

    private EditCategoryRequest editCategoryRequest;

    @Inject
    private CategoryService categoryService;

    @Inject
    Retriever retriever;

    public EditCategoryRequest getEditRequest() {
        if (editCategoryRequest == null) {
            editCategoryRequest = createEditCategoryRequest();
        }
        return editCategoryRequest;
    }

    private EditCategoryRequest createEditCategoryRequest() {
        if (retriever.contains("categoryId")) {
            var categoryId = retriever.getLong("categoryId");
            var category = categoryService.findCategoryById(categoryId).orElseThrow();  //TODO
            return new EditCategoryRequest(category);
        }
        return new EditCategoryRequest();
    }

    public String save() {

        var branch = categoryService.getBranchFromCategory(editCategoryRequest.getId()).orElseThrow();
        categoryService.save(new Category(editCategoryRequest.getId(), editCategoryRequest.getName(), branch));

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }

}
