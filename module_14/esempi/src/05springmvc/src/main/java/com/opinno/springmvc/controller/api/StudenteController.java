package com.opinno.springmvc.controller.api;

import com.opinno.springmvc.model.Studente;
import com.opinno.springmvc.model.http.RequestHelloWorld;
import com.opinno.springmvc.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @GetMapping("/helloworld/{id}")
    public ResponseEntity<String> helloWorldPathVar(@PathVariable Long id) {

        System.out.println(id);

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorldRequestParam(@RequestParam Long id) {

        System.out.println(id);

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    // DTO --> Data Transfer Object (Pattern)
    @PostMapping("/helloworld")
    public ResponseEntity<String> helloWorldBodyParam(@RequestBody RequestHelloWorld requestHelloWorld) {

        System.out.println(requestHelloWorld);

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }



    @GetMapping("/studenti")
    public ResponseEntity<List<Studente>> getAllStudenti() {

        List<Studente> studenti = studenteService.findAllStudents();

        return new ResponseEntity<>(studenti, HttpStatus.OK);
    }
}
