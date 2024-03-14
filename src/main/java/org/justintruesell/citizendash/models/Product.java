package org.justintruesell.citizendash.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * This class will not be necessarily connected via a foreign key
 * but will be another table in the database to help users populate
 * stardardized values of products others and themselves
 * have already entered into the system, as well as their price history.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    /**
     * Each product will have its own id, two identical products are
     * considered different if they are from separate retailers.
     * The same if it is the same size, product, brand and from one retailer.
     * So two identical products can have different ID's if from
     * different retailers.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String store;
    private String brand;
    private String size;
    //track products average, all-time price, no date needed
    private float averagePrice;
    //track most recent price and date
    private float latestPrice;
    private Date latestPriceDate;
    //track lowest price and date
    private float lowestPrice;
    private Date lowestPriceDate;
    //track highest price and date
    private float highestPrice;
    private Date highestPriceDate;

}
