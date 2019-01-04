package com.wildcodeschool.bookApiRest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.bookApiRest.Entity.Book;
import com.wildcodeschool.bookApiRest.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	
	//POUR TOUT AVOIR
	@GetMapping("/books")
	//on va chercher la liste de tout la collection BOOK et on retourne cette collection
	public List<Book>index(){
		return bookRepository.findAll();
	}
	
	//pour aller chercher un seul livre de la collection BOOK
	@GetMapping("/books/{id}")
	public Book show(@PathVariable int id) {
		return bookRepository.getOne(id);
	}

	//
	@PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrDescriptionContaining(searchTerm, searchTerm);
	}
	
	
	//pour créer un nouveau livre. le @requestBody permet de récuperer le corps des infos sous format JSON
    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }
    
    
    //equivalent de update
    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book book){
        // on crée un object temporaire 
        Book bookToUpdate = bookRepository.findById(id).get();
        //on doit passer par des getters et des setters pour tout le corps de la requête
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return bookRepository.save(bookToUpdate);
    }
    
    
    //delete
    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable Integer id){
        bookRepository.deleteById(id);
        return true;
    }
}
