package br.com.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveWebSampleApplication

fun main(args: Array<String>) {
    runApplication<ReactiveWebSampleApplication>(*args)
}