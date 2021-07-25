package net.mysql.product.model;

import javax.persistence.*;

// defines class can be mapped to a table (rdb)
@Entity
@Table(name="product")
public class Product {
    private Integer id;
    private String name;
    private float price;

    public Product() {}

    public Product(Integer id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Specifies this is the id field in db
    @Id
    // Lets spring boot know its auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
