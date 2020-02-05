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

        }
        return new EditCategoryRequest();
    }

    public String save() {

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }

}
