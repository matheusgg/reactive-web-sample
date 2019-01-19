package br.com.sample.reactive

import br.com.sample.document.Book
import br.com.sample.service.BookService
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromPublisher
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class BookHandler(private val service: BookService) {

    fun findById(request: ServerRequest) = ok()
            .contentType(APPLICATION_JSON)
            .body(this.service.findById(request.pathVariable("id")), Book::class.java)

    fun findAll(request: ServerRequest) = ok()
            .contentType(APPLICATION_JSON)
            .body(this.service.findAll(), Book::class.java)

    fun save(request: ServerRequest): Mono<ServerResponse> {
        val body = request.bodyToMono(Book::class.java)
        return ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(body.flatMap { this.service.save(it) }, Book::class.java))
    }

    fun deleteById(request: ServerRequest) = ok()
            .contentType(APPLICATION_JSON)
            .body(this.service.deleteById(request.pathVariable("id")), Void::class.java)
}