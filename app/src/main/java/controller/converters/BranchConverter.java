package controller.converters;


import controller.CategoryController;
import liquibase.util.StringUtils;
import model.Branch;
import repository.BranchRepository;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Iterator;
import java.util.List;

public class BranchConverter implements Converter {

    @Inject
    private BranchRepository branchRepository;

    public Branch getAsObject(FacesContext context, UIComponent component, String value) {
        if(value == null || value.equals("")) {
            return null;
        }
        Branch branch = branchRepository.findBranchById(Long.valueOf(value));
        //or if it is not a String, replace value with Integer.parseInt(value)
        if(branch == null) {
            throw new ConverterException(new FacesMessage("Branch with id: " + value + " not found."));
        }
        return branch;
    }



    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (!(value instanceof Branch) || (value == null)) {
            return null;
        }
        return ((Branch)value).getName();
    }
}
