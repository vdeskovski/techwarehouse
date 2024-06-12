package mk.ukim.finki.techshop.service;

import mk.ukim.finki.techshop.model.Manufacturer;
import mk.ukim.finki.techshop.model.dto.ManufacturerDTO;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> fetchAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> save(ManufacturerDTO manufacturerDTO);
    Optional<Manufacturer> edit(Long id, ManufacturerDTO manufacturerDTO);
    Optional<Manufacturer> deleteById(Long id);
}
