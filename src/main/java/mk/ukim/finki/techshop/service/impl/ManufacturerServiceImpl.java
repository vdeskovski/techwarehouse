package mk.ukim.finki.techshop.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.techshop.model.Manufacturer;
import mk.ukim.finki.techshop.model.dto.ManufacturerDTO;
import mk.ukim.finki.techshop.model.exception.ManufacturerIdNotFoundException;
import mk.ukim.finki.techshop.repo.ItemRepo;
import mk.ukim.finki.techshop.repo.ManufacturerRepo;
import mk.ukim.finki.techshop.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepo manufacturerRepo;
    private final ItemRepo itemRepo;

    public ManufacturerServiceImpl(ManufacturerRepo manufacturerRepo, ItemRepo itemRepo) {
        this.manufacturerRepo = manufacturerRepo;
        this.itemRepo = itemRepo;
    }

    @Override
    public List<Manufacturer> fetchAll() {
        return manufacturerRepo.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepo.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(ManufacturerDTO manufacturerDTO) {
        String name = manufacturerDTO.getName();
        String description = manufacturerDTO.getDescription();
        String address = manufacturerDTO.getAddress();
        LocalDate dateFounded = manufacturerDTO.getDateFounded();
        Manufacturer manufacturer = new Manufacturer(name,description,address,dateFounded);
        return Optional.of(manufacturerRepo.save(manufacturer));
    }

    @Override
    public Optional<Manufacturer> edit(Long id, ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = findById(id).orElseThrow(ManufacturerIdNotFoundException::new);
        String name = manufacturerDTO.getName();
        String description = manufacturerDTO.getDescription();
        String address = manufacturerDTO.getAddress();
        LocalDate dateFounded = manufacturerDTO.getDateFounded();
        manufacturer.setName(name);manufacturer.setAddress(address);
        manufacturer.setDescription(description);manufacturer.setDateFounded(dateFounded);
        return Optional.of(manufacturerRepo.save(manufacturer));
    }

    @Transactional
    @Override
    public Optional<Manufacturer> deleteById(Long id) {
        Manufacturer manufacturer = findById(id).orElseThrow(ManufacturerIdNotFoundException::new);
        itemRepo.deleteByManufacturerId(id);
        manufacturerRepo.deleteById(id);
        return Optional.of(manufacturer);
    }
}
