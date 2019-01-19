package br.com.sample.service

import br.com.sample.document.Book
import br.com.sample.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(private val repository: BookRepository) {

    fun findById(id: String) = this.repository.findById(id)

    fun findAll() = this.repository.findAll()

    fun save(book: Book) = this.repository.save(book)

    fun deleteById(id: String) = this.repository.deleteById(id)
}