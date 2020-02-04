package request.add;

import model.Parametr;

public class AddParamRequest {

    private Long id;
    private String value;

    public AddParamRequest(Parametr param) {
        this.id = id;
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

    public AddParamRequest() {
    }


    public Parametr toParam() {
        return new Parametr(id, value);
    }

}
