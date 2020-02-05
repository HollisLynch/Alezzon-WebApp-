package controller.edit;

import controller.Retriever;
import request.CategoryRequest;
import service.CategoryService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class EditCategoryController {

    private CategoryRequest editCategoryRequest;

    @Inject
    private CategoryService categoryService;

    @Inject
    Retriever retriever;

    public CategoryRequest getEditRequest() {
        if (editCategoryRequest == null) {
            editCategoryRequest = createEditCategoryRequest();
        }
        return editCategoryRequest;
    }

    private CategoryRequest createEditCategoryRequest() {
        if (retriever.contains("categoryId")) {

        }
        return new CategoryRequest();
    }

    public String save() {

        return "/admin/category/categoryList.xhtml?faces-redirect=true";
    }

}
