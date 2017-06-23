package com.kunalherkal.paperwork.models;

import com.kunalherkal.paperwork.models.dto.RentAgreement;
import com.kunalherkal.paperwork.utils.Constants;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class RentAgreementFirstPage extends WordDocument implements Creatable {
    private final RentAgreement rentAgreement;
    private final int width = 11900;
    private final int height = 16840;

    public RentAgreementFirstPage(RentAgreement rentAgreement) {
        this.rentAgreement = rentAgreement;
    }

    @Override
    public String create() throws IOException {
        XWPFDocument document = new XWPFDocument();
        setSize(document, width, height);

        XWPFParagraph paragraph1 = document.createParagraph();
        paragraph1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = paragraph1.createRun();
        run1.setFontSize(18);
        run1.setUnderline(UnderlinePatterns.SINGLE);
        addBreak(run1, 28);
        run1.setText(Constants.AGREEMENT_NAME);

        XWPFParagraph paragraph2 = document.createParagraph();
        paragraph2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = paragraph2.createRun();
        run2.setFontSize(12);
        run2.setText("This agreement is made at " + rentAgreement.getExecutionCity() + " on " + rentAgreement.getExecutionDate());
        run2.addBreak();
        run2.setText("BETWEEN");
        addBreak(run2, 3);
        run2.setText(Constants.OWNER);
        addTab(run2, 9);
        run2.setText(Constants.TENANT);

        String pathname = "firstPage.docx";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(pathname));
        document.write(fileOutputStream);
        fileOutputStream.close();

        return pathname;
    }
}
