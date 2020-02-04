package controller;


import model.User;
import repository.UserRepository;
import request.LoginRequest;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private HttpServletRequest request;
    @Inject
    UserRepository userRepository;



    public String login() {

        User user = userRepository.selectSingleResWithUsername(loginRequest.getUsername());

        if ( logIn(loginRequest.getUsername(), loginRequest.getPassword())) {
            if (user.getRole().equals("admin")) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);

                session.setAttribute("admin", user.getUsername());
                return  "/admin.xhtml?faces-redirect=true";
            }
            else {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
                session.setAttribute("username", user.getUsername());
                return "/welcome.xhtml?faces-redirect=true";
            }
        }
        else {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().put("error-message", "Incorrect username or password");
            return "/login.xhtml?faces-redirect=true";
        }
    }


    public boolean logIn(String username, String password) {
        if (ifUserExists(username, password)) {
            User u = userRepository.selectSingleResWithUsername(username);
            var session = request.getSession(true);
            session.setAttribute("username", username);
            session.setAttribute("role", u.getRole());
            session.setAttribute("id", u.getId());
            return true;
        }
        return false;
    }

    public boolean ifUserExists(String username, String password) {
        User user = new User(username, password);
        var list = em.createQuery("from User where username = :username and password = :password", User.class)
                .setParameter("username", user.getUsername())
                .setParameter("password", user.getPassword())
                .getResultList();
        if (list.isEmpty())
            return false;
        else
            return true;
    }



}
