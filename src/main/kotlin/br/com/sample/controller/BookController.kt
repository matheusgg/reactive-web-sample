package br.com.sample.controller

import br.com.sample.document.Book
import br.com.sample.service.BookService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(private val service: BookService) {

    @GetMapping("/{id}")
    fun retrieveById(@PathVariable id: String) = this.service.findById(id)

    @GetMapping
    fun retrieveAll() = this.service.findAll()

    @PostMapping
    fun save(@RequestBody book: Book) = this.service.save(book)

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: String) = this.service.deleteById(id)
}