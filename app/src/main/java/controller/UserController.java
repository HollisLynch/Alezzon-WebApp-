package controller;

import model.User;
import request.RegisterRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

@Named
@ApplicationScoped
public class UserController {

    @Inject
    private RegisterRequest registerRequest;

    @Inject
    private LoginController loginController;

    @Inject
    private HttpServletRequest request;

    @PersistenceContext
    private EntityManager em;


    @Transactional
    public String register() {

        User user = new User(registerRequest.getName(), registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getEmail(), registerRequest.getBirthDate(), registerRequest.getRole());
        addUser(user);
        return "/login.xhtml?faces-redirect=true";
    }

    public void addUser(User user) {
        if (loginController.ifUserExists(registerRequest.getUsername(), registerRequest.getPassword())) {
            throw new IllegalStateException(String.format("User %s already exists.", user.getUsername()));
        } else {
            em.persist(user);
            var session = request.getSession(true);
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
        }

    }
}
