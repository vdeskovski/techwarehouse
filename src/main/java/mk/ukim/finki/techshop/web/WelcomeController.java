package mk.ukim.finki.techshop.web;


import mk.ukim.finki.techshop.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class WelcomeController {
    @GetMapping
    public String getIndexPage() {
        return "index";
    }
}
