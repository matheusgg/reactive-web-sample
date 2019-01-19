package br.com.sample.reactive

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.DELETE
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RequestPredicates.POST
import org.springframework.web.reactive.function.server.RequestPredicates.accept
import org.springframework.web.reactive.function.server.RouterFunctions.route

@Configuration
class BookRouterConfig {

    @Bean
    fun bookRouter(handler: BookHandler) = route(GET("/reactive/books").and(accept(APPLICATION_JSON)), HandlerFunction { handler.findAll(it) })
            .andRoute(GET("/reactive/books/{id}").and(accept(APPLICATION_JSON)), HandlerFunction { handler.findById(it) })
            .andRoute(POST("/reactive/books").and(accept(APPLICATION_JSON)), HandlerFunction { handler.save(it) })
            .andRoute(DELETE("/reactive/books/{id}").and(accept(APPLICATION_JSON)), HandlerFunction { handler.deleteById(it) })
}