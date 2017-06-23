package com.kunalherkal.paperwork.services;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class DocumentDownloaderService {

    public ResponseEntity<ByteArrayResource> download(String id) {
        String fileName = resolveFileName(id);
        File file = new File(fileName);
        Path path = Paths.get(file.getAbsolutePath());
        ByteArrayResource byteArrayResource = getByteArrayResource(path);
        HttpHeaders headers = getHttpHeaders(fileName, file.length());

        return ResponseEntity.ok()
                .headers(headers)
                .body(byteArrayResource);
    }

    private HttpHeaders getHttpHeaders(String pathname, long contentLength) {
        HttpHeaders headers = new HttpHeaders();
        headers.setExpires(0);
        headers.setContentDispositionFormData("attachment", pathname);
        headers.setContentType(MediaType.parseMediaType("application/octet-stream"));
        headers.setContentLength(contentLength);
        headers.setCacheControl("no-cache, no-store, must-revalidate");
        headers.setPragma("no-cache");
        return headers;
    }

    private String resolveFileName(String id) {
        if (id.endsWith(".docx"))
            return id;
        else
            return id + ".docx";
    }

    private ByteArrayResource getByteArrayResource(Path path) {
        try {
            return new ByteArrayResource(Files.readAllBytes(path));
        } catch (IOException e) {
            e.printStackTrace();
            byte[] byteArray = new byte[0];
            return new ByteArrayResource(byteArray);
        }
    }
}
