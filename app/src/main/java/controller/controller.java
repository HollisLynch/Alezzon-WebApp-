package controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class controller {

    public String boo() {
        return "admin.xhtml";
    }
}
