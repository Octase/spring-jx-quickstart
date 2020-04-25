package com.octase.springjxquickstart.web

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class SampleController() {

    @GetMapping("/hello")
    fun getArt(): ResponseEntity<String> {
        return ResponseEntity.ok("World")
    }

}