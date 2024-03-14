package org.justintruesell.citizendash.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Purchases {
    @Id
    private String productsFile;
    @Column(unique = true)
    private Long id;
}
