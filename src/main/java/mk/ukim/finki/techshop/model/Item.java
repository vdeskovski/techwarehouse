package mk.ukim.finki.techshop.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String description;
    private int price;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Manufacturer manufacturer;

    public Item(String name, String description, int price, int quantity, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }

    public Item() {

    }
}
