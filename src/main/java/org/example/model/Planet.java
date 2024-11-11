package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 10, nullable = false)
    @Pattern(regexp = "^[A-Z0-9]+$", message = "ID must contain only uppercase Latin letters and digits")
    private String id;
    @Column(nullable = false, length = 500)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
