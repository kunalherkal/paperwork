package com.kunalherkal.paperwork.controllers;

import com.kunalherkal.paperwork.models.dto.Person;
import com.kunalherkal.paperwork.services.DocumentCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PersonController {
    private DocumentCreator documentCreator;

    @Autowired
    public PersonController(DocumentCreator documentCreator) {
        this.documentCreator = documentCreator;
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson(@RequestParam(value = "name", defaultValue = "") String name) throws IOException {
        Person person = new Person(name, "Herkal", 25);
        documentCreator.create(person);
        return person;
    }
}
