package com.kunalherkal.paperwork.controllers;

import com.kunalherkal.paperwork.models.dto.RentAgreement;
import com.kunalherkal.paperwork.services.DocumentCreatorService;
import com.kunalherkal.paperwork.services.DocumentDownloaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DocumentController {
    private DocumentCreatorService documentCreatorService;
    private DocumentDownloaderService documentDownloaderService;

    @Autowired
    public DocumentController(DocumentCreatorService documentCreatorService,
                              DocumentDownloaderService documentDownloaderService) {
        this.documentCreatorService = documentCreatorService;
        this.documentDownloaderService = documentDownloaderService;
    }

    @PostMapping(value = "/document/create", consumes = "application/json")
    public Map<String, String> create(@RequestBody RentAgreement agreement) {
        return documentCreatorService.create(agreement);
    }

    @GetMapping(value = "/document/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(value = "id") String id) {
        return documentDownloaderService.download(id);
    }
}
