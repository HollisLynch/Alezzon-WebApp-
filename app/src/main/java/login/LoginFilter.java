package login;

import model.User;

import javax.faces.application.ResourceHandler;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        if (isResourceReq(req) || isSiteAllowed(req) || isUserLogged(req)) {


            chain.doFilter(req, res);
        } else if (isResourceReq(req) || isAdminSite(req) || isAdminLogged(req)) {



            chain.doFilter(req, res);
        } else {
            res.sendRedirect(getServletContext().getContextPath() + "/login.xhtml");
        }

    }


    private boolean isResourceReq(HttpServletRequest req) {

        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isSiteAllowed(HttpServletRequest req) {

        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/registration.xhtml");
    }

    private boolean isUserLogged(HttpServletRequest req) {
        var session = req.getSession(false);
        return session != null && session.getAttribute("username") != null;
    }

    private boolean isAdminSite(HttpServletRequest req) {

        return req.getRequestURI().equals(req.getContextPath() + "/admin.xhtml") ||
                req.getRequestURI().contains("admin");
    }

    private boolean isAdminLogged(HttpServletRequest req) {
        var session = req.getSession(false);

        return session != null && session.getAttribute("admin") != null;
    }
}
