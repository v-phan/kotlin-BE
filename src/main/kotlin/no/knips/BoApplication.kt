package no.knips

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import javax.security.auth.Subject

@SpringBootApplication
class BoApplication

fun main(args: Array<String>) {
	runApplication<BoApplication>(*args)
}


