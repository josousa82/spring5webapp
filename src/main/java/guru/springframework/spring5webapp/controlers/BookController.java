package guru.springframework.spring5webapp.controlers;

import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sousaJ on 12/08/2020
 * in package - guru.springframework.spring5webapp.controlers
 **/
@Controller
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books/list")
    public String getBooks(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/list";
    }
}
