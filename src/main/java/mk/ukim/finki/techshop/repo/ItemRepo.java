package mk.ukim.finki.techshop.repo;

import mk.ukim.finki.techshop.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
    Optional<Item> findByNameEqualsIgnoreCase(String name);
    void deleteByManufacturerId(Long manufacturerId);
}
