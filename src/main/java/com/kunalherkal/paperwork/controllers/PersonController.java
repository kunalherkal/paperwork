package com.kunalherkal.paperwork.controllers;

import com.kunalherkal.paperwork.models.dto.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PersonController {

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Person getPerson(@RequestParam(value = "name", defaultValue = "") String name) {
        return new Person(name, "Herkal", 25);
    }
}
