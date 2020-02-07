package model;

import request.CategoryRequest;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Branch branch;

    @Column(nullable = false)
    private String name;

    public Category() {
    }

    public Category(CategoryRequest cr) {
        this.branch =new Branch();// cr.getBranchId();
        this.name = cr.getName();
    }

    public Category(String name, Branch branch) {
        this.branch = branch;
        this.name = name;
    }
    public Category(String name) {
        this.name = name;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Branch getBranchId() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
