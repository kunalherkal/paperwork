package com.kunalherkal.paperwork.services;

import com.kunalherkal.paperwork.models.dto.Person;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class DocumentCreator {

    public void create(Person person) throws IOException {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("document.docx"));

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(person.toString());

        document.write(fileOutputStream);
        fileOutputStream.close();
    }
}
