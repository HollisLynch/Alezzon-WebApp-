package controller.list;


import model.Category;
import repository.CategoryRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class ListCategoryController {
    @Inject
    CategoryRepository categoryRepository;

    public List<Category> getCategoryList() {

        return categoryRepository.findAll();
    }
}
