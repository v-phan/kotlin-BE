package no.boapi.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BoApplication

fun main(args: Array<String>) {
	runApplication<BoApplication>(*args)
}
