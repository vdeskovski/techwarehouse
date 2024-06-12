package mk.ukim.finki.techshop.web;

import mk.ukim.finki.techshop.model.Category;
import mk.ukim.finki.techshop.model.Item;
import mk.ukim.finki.techshop.model.Manufacturer;
import mk.ukim.finki.techshop.model.dto.ItemDTO;
import mk.ukim.finki.techshop.model.dto.ManufacturerDTO;
import mk.ukim.finki.techshop.service.ItemService;
import mk.ukim.finki.techshop.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {
    private final ItemService itemService;
    private final ManufacturerService manufacturerService;

    public ItemController(ItemService itemService, ManufacturerService manufacturerService) {
        this.itemService = itemService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getAllItems(Model model){
        model.addAttribute("items", itemService.fetchAll());
        return "items";
    }

    @GetMapping("/add")
    public String addItem(Model model){
        model.addAttribute("mans", manufacturerService.fetchAll());
        model.addAttribute("categories", Category.values());
        return "add-item";
    }

    @PostMapping("/add")
    public String addItem(@ModelAttribute ItemDTO itemDTO){
        itemService.save(itemDTO);
        return "redirect:/items";
    }

    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, Model model){
        Optional<Item> item = itemService.findById(id);
        model.addAttribute("item", item.get());
        model.addAttribute("mans", manufacturerService.fetchAll());
        model.addAttribute("categories", Category.values());
        return "add-item";
    }

    @PostMapping("/edit/{id}")
    public String editItem(@PathVariable Long id, @ModelAttribute ItemDTO itemDTO){
        itemService.edit(id,itemDTO);
        return "redirect:/items";
    }

    @PostMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id){
        itemService.deleteById(id);
        return "redirect:/items";
    }

    @GetMapping("/details/{id}")
    public String detailsMan(@PathVariable Long id, Model model){
        model.addAttribute("i", itemService.findById(id).get());
        return "details-item";
    }

}
