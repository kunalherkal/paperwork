package com.kunalherkal.paperwork.models;

import com.kunalherkal.paperwork.models.dto.RentAgreement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RentAgreementSecondPage extends WordDocument implements Creatable {
    private final RentAgreement rentAgreement;
    private final int height = 20160;
    private final int width = 12240;

    public RentAgreementSecondPage(RentAgreement rentAgreement) {
        this.rentAgreement = rentAgreement;
    }

    @Override
    public String create() throws IOException {
        XWPFDocument document = new XWPFDocument();
        setSize(document, width, height);

        String pathname = "secondPage.docx";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(pathname));

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(rentAgreement.toString());

        document.write(fileOutputStream);
        fileOutputStream.close();
        return pathname;
    }
}
