package com.octase.springjxquickstart.web

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.client.RestTemplate


@JsonIgnoreProperties(ignoreUnknown = true)
data class Quote(var quote: String = "")

@Controller
class HelloController() {

    val restTemplate = RestTemplate()

    @GetMapping("/hello")
    fun sayHello(): ResponseEntity<String> {
        return ResponseEntity.ok("World")
    }

    @GetMapping("/")
    fun welcome(): ResponseEntity<String> {
        return ResponseEntity.ok("You can type /hello or check what I am thinking with /thought")
    }

    @GetMapping("/thought")
    fun thought(): ResponseEntity<Quote> {
        val headers = HttpHeaders()
        headers["User-Agent"] = "needed"
        val res = restTemplate.exchange("https://api.kanye.rest/", HttpMethod.GET,
                HttpEntity<String>(headers), Quote::class.java)
        return ResponseEntity.ok(res.body!!)
    }


}