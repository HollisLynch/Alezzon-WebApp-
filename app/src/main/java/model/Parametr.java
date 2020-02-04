package model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "parametr")
public class Parametr {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    @OneToMany
    @JoinColumn(name = "parametr_id")
    private Collection<ProductParametr> parametrs;

    public Collection<ProductParametr> getParametrs() {
        return parametrs;
    }

    public void setParametrs(Collection<ProductParametr> parametrs) {
        this.parametrs = parametrs;
    }

    public Parametr() {
    }

    public Parametr(Long id, String value) {
    }

    public Parametr(String paramName) {
        this.value = paramName;
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
}
