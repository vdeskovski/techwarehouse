package mk.ukim.finki.techshop.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import mk.ukim.finki.techshop.model.Category;
import mk.ukim.finki.techshop.model.Manufacturer;

@Data
public class ItemDTO {
    private String name;
    private String description;
    private int price;
    private int quantity;
    private Category category;
    private Manufacturer manufacturer;

    public ItemDTO(String name, String description, int price, int quantity, Category category, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.manufacturer = manufacturer;
    }
}
