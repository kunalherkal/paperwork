package com.kunalherkal.paperwork.controllers;

import com.kunalherkal.paperwork.services.DocumentCreatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class PersonController {
    private DocumentCreatorService documentCreatorService;

    @Autowired
    public PersonController(DocumentCreatorService documentCreatorService) {
        this.documentCreatorService = documentCreatorService;
    }


    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", defaultValue = "") String name, Model model) throws IOException {
        model.addAttribute("name", name);
        model.addAttribute("firstPageId", "firstPage");
        model.addAttribute("secondPageId", "secondPage");
        return "download";
    }
}
