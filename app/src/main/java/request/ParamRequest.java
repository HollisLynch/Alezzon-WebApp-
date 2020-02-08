package request;

import model.Parametr;

import java.io.Serializable;

public class ParamRequest implements Serializable {

    private Long id;
    private String value;


    public ParamRequest(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public ParamRequest(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ParamRequest() {
    }


    public Parametr toParam() {
        return new Parametr(id, value);
    }

}
