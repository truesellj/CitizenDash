package org.justintruesell.citizendash.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String store;
    private String brand;
    private String size;
    private float averagePrice;
    private float latestPrice;
    private Date latestPriceDate;
    private float lowestPrice;
    private Date lowestPriceDate;
    private float highestPrice;
    private Date highestPriceDate;

}
