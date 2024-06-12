package mk.ukim.finki.techshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
public class Manufacturer {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private String address;
    private LocalDate dateFounded;

    public Manufacturer(String name, String description, String address, LocalDate dateFounded) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.dateFounded = dateFounded;
    }

    public Manufacturer() {

    }
}
