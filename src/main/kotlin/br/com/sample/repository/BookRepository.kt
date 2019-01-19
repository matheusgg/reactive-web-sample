package br.com.sample.repository

import br.com.sample.document.Book
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface BookRepository : ReactiveMongoRepository<Book, String>