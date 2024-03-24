package org.justintruesell.citizendash.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@NamedQuery(name="Todo.findByOwner",query = "SELECT t FROM Todo t WHERE t.owner = ?1")
public class Todo {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@OneToOne(mappedBy="user")
    private String owner;

    private String title;
    private String itemOne;
    private String itemTwo;
    private String itemThree;
    /**
    @ElementCollection
    private ArrayList<String> todos;
    */

    //private String fileName;
}
