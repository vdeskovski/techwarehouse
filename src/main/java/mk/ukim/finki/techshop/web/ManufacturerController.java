package mk.ukim.finki.techshop.web;

import mk.ukim.finki.techshop.model.Manufacturer;
import mk.ukim.finki.techshop.model.dto.ManufacturerDTO;
import mk.ukim.finki.techshop.service.ManufacturerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/mans")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getAllMans(Model model){
        model.addAttribute("manufacturers", manufacturerService.fetchAll());
        return "manufacturers";
    }

    @GetMapping("/add")
    public String addMan(){
        return "add-manufacturer";
    }

    @PostMapping("/add")
    public String addMan(@ModelAttribute ManufacturerDTO manufacturerDTO){
        manufacturerService.save(manufacturerDTO);
        return "redirect:/mans";
    }

    @GetMapping("/edit/{id}")
    public String editMan(@PathVariable Long id, Model model){
        Optional<Manufacturer> manufacturer = manufacturerService.findById(id);
        model.addAttribute("manufacturer", manufacturer.get());
        return "add-manufacturer";
    }

    @PostMapping("/edit/{id}")
    public String editMan(@PathVariable Long id, @ModelAttribute ManufacturerDTO manufacturerDTO){
        manufacturerService.edit(id,manufacturerDTO);
        return "redirect:/mans";
    }

    @PostMapping("/delete/{id}")
    public String deleteMan(@PathVariable Long id){
        manufacturerService.deleteById(id);
        return "redirect:/mans";
    }

    @GetMapping("/details/{id}")
    public String detailsMan(@PathVariable Long id, Model model){
        model.addAttribute("m", manufacturerService.findById(id).get());
        return "details-manufacturer";
    }

}
