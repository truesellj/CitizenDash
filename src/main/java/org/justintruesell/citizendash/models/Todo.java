package org.justintruesell.citizendash.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @Column(unique = true)
    private String title;
    private String fileName;
    private int id;

}
