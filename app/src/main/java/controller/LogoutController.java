package controller;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Named
@RequestScoped
public class LogoutController {


    public String logOut() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context
                .getExternalContext()
                .getRequest();

        try {
            request.getSession(true).invalidate();
            request.logout();

        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Logout failed."));
        }

        return "/login.xhtml?faces-redirect=true";

    }


}
