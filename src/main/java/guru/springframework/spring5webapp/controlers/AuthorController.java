package guru.springframework.spring5webapp.controlers;

/**
 * Created by sousaJ on 14/08/2020
 * in package - guru.springframework.spring5webapp.controlers
 **/

import guru.springframework.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {
    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors/list")
    public String getAuthors(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/list";
    }
}
