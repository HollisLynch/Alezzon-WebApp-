package login;

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

        /*
        0. ) if the request is resource, process the request.
        1. ) Check if the user is logged in && !requires login -> process request .  Otherwise, redirect to login.
        2. ) If the user has access rights, process the request. Otherwise, redirect to nopermission.xhtml
        these should be in separate if elses.
         */

        if (isResourceReq(req)|| isSiteAllowed(req)){
            chain.doFilter(req, res);
            return;
        }
        if (  isUserLogged(req)) {

            boolean isAdminSite
                    =isAdminSite(req);
            boolean hasAdminRights=hasAdminRights(req);
            String reqUri=req.getRequestURI();

            if ( ( isAdminSite&& !hasAdminRights ) ) {
                res.sendRedirect(getServletContext().getContextPath() + "/welcome.xhtml");

              }else {
                chain.doFilter(req, res);

                    }

                }
          else {
            res.sendRedirect(getServletContext().getContextPath() + "/login.xhtml");
        }


    }


    private boolean isResourceReq(HttpServletRequest req) {

        return req.getRequestURI().startsWith(
                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
    }

    private boolean isSiteAllowed(HttpServletRequest req) {
        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/registration.xhtml") ||
                req.getRequestURI().equals(req.getContextPath() + "/index.xhtml");
    }


    private boolean isUserLogged(HttpServletRequest req) {
        var session = req.getSession(false);
        return session != null && session.getAttribute("username") != null;
    }

    private boolean isAdminSite(HttpServletRequest req) {

        return (req.getRequestURI().equals(req.getContextPath() + "/admin.xhtml") ||
                req.getRequestURI().contains("add") ||
                req.getRequestURI().contains("edit") )
                &&!req.getRequestURI().contains("product")
                &&!req.getRequestURI().contains("Product");
    }

    private boolean hasAdminRights(HttpServletRequest req) {
        var session = req.getSession(false);

        return session != null && session.getAttribute("admin") != null;
    }
}
