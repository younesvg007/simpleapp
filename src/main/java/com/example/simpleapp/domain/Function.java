package com.example.simpleapp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "functions")
public class Function implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "function_id")
    private Integer id;
    private String name;

    public Function(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Function() {

    }

    public Integer getId() {
        return id;
    }

    public Function setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Function setName(String name) {
        this.name = name;
        return this;
    }
}
