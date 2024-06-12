package mk.ukim.finki.techshop.service.impl;

import mk.ukim.finki.techshop.model.Category;
import mk.ukim.finki.techshop.model.Item;
import mk.ukim.finki.techshop.model.Manufacturer;
import mk.ukim.finki.techshop.model.dto.ItemDTO;
import mk.ukim.finki.techshop.model.exception.ItemIdNotFoundException;
import mk.ukim.finki.techshop.repo.ItemRepo;
import mk.ukim.finki.techshop.repo.ManufacturerRepo;
import mk.ukim.finki.techshop.service.ItemService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;
    private final ManufacturerRepo manufacturerRepo;

    public ItemServiceImpl(ItemRepo itemRepo, ManufacturerRepo manufacturerRepo) {
        this.itemRepo = itemRepo;
        this.manufacturerRepo = manufacturerRepo;
    }

    @Override
    public List<Item> fetchAll() {
        return itemRepo.findAll();
    }

    @Override
    public Optional<Item> findById(Long id) {
        return itemRepo.findById(id);
    }

    @Override
    public Optional<Item> save(ItemDTO itemDTO) {
        String name = itemDTO.getName();
        if(fetchAll().stream().anyMatch(i -> i.getName().equalsIgnoreCase(name) && i.getManufacturer().getId().equals(itemDTO.getManufacturer().getId()))){
            Item item = itemRepo.findByNameEqualsIgnoreCase(name).orElseThrow(ItemIdNotFoundException::new);
            item.setQuantity(item.getQuantity() + itemDTO.getQuantity());
            return Optional.of(itemRepo.save(item));
        }
        String description = itemDTO.getDescription();
        int price = itemDTO.getPrice();
        int quantity = itemDTO.getQuantity();
        Category category = itemDTO.getCategory();
        Manufacturer manufacturer = itemDTO.getManufacturer();
        Item item = new Item(name,description,price,quantity,category,manufacturer);
        return Optional.of(itemRepo.save(item));
    }

    @Override
    public Optional<Item> edit(Long id, ItemDTO itemDTO) {
        Item item = findById(id).orElseThrow(ItemIdNotFoundException::new);
        String name = itemDTO.getName();
        String description = itemDTO.getDescription();
        int price = itemDTO.getPrice();
        int quantity = itemDTO.getQuantity();
        Category category = itemDTO.getCategory();
        Manufacturer manufacturer = itemDTO.getManufacturer();
        item.setName(name);item.setDescription(description);item.setPrice(price);item.setQuantity(quantity);
        item.setCategory(category);item.setManufacturer(manufacturer);
        return Optional.of(itemRepo.save(item));
    }

    @Override
    public Optional<Item> deleteById(Long id) {
        Item item = findById(id).orElseThrow(ItemIdNotFoundException::new);
        itemRepo.delete(item);
        return Optional.of(item);
    }
}
