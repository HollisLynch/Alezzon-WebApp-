package controller.converters;

import model.Branch;
import model.Parametr;
import request.CategoryRequest;

import javax.el.ValueExpression;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@ApplicationScoped
public class Retriever{
    @Inject
    private HttpServletRequest request;

    public boolean contains(String key) {
        return request.getParameter(key) != null;
    }

    public Long getLong(String key) {
        var value = request.getParameter(key);
        return Long.parseLong(value);
    }



    public Long getLongUserId(String str) {
        return (Long)request.getSession().getAttribute(str);
    }

    public Long getAsLong(Object value) {
        return ((CategoryRequest)value).getId();
    }

    public String getAsString(Object value) {
        return String.valueOf(((Parametr)value).getId());
    }


//    public Branch getAsObject(Long o) {
//
//        CategoryRequest categoryRequest = new CategoryRequest();
//        Branch id = Branch.valueOf(o);
//
//        return categoryRequest.getBranchId(id);
//    }

//    public Object getAsObject(FacesContext ctx, UIComponent component, String value) {
//        ValueExpression vex =
//                ctx.getApplication().getExpressionFactory()
//                        .createValueExpression(ctx.getELContext(),
//                                "#{branch}", CategoryRequest.class);
//
//        CategoryRequest categoryRequest = (CategoryRequest)vex.getValue(ctx.getELContext());
//        return categoryRequest.getBranchId(Long.valueOf(value));
//    }
//
//    public String getAsString(FacesContext context, UIComponent component, Object value) {
//        return ((CategoryRequest)value).getId().toString();
//    }
}
