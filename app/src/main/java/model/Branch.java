package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "section")
public class Branch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    public Branch(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Branch))//changed this from (getClass() != obj.getClass())
            return false;
        Branch other = (Branch) obj;

        return other.id == id;
    }

}
