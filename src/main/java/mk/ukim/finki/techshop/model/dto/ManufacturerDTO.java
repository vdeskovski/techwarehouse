package mk.ukim.finki.techshop.model.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class ManufacturerDTO {
    private String name;
    private String description;
    private String address;
    private LocalDate dateFounded;

    public ManufacturerDTO(String name, String description, String address, LocalDate dateFounded) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.dateFounded = dateFounded;
    }
}
