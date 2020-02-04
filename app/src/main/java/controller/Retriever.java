package controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@ApplicationScoped
public class Retriever {
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
}
