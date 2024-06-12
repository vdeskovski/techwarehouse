package mk.ukim.finki.techshop.service;

import mk.ukim.finki.techshop.model.Item;
import mk.ukim.finki.techshop.model.dto.ItemDTO;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> fetchAll();
    Optional<Item> findById(Long id);
    Optional<Item> save(ItemDTO itemDTO);
    Optional<Item> edit(Long id, ItemDTO itemDTO);
    Optional<Item> deleteById(Long id);
}
