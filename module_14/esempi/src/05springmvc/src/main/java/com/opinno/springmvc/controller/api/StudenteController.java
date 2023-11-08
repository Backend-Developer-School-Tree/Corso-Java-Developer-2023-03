package com.opinno.springmvc.controller.api;

import com.opinno.springmvc.model.Studente;
import com.opinno.springmvc.service.StudenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudenteController {

    @Autowired
    StudenteService studenteService;

    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld() {

        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("/studenti")
    public ResponseEntity<List<Studente>> getAllStudenti() {

        List<Studente> studenti = studenteService.findAllStudents();

        return new ResponseEntity<>(studenti, HttpStatus.OK);
    }
}
