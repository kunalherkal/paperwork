package com.kunalherkal.paperwork.models;

import com.kunalherkal.paperwork.models.dto.RentAgreement;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class RentAgreementFirstPage implements Creatable {
    private final RentAgreement rentAgreement;

    public RentAgreementFirstPage(RentAgreement rentAgreement) {
        this.rentAgreement = rentAgreement;
    }

    @Override
    public String create() throws IOException {
        XWPFDocument document = new XWPFDocument();

        CTBody body = document.getDocument().getBody();
        if(!body.isSetSectPr()){
            body.addNewSectPr();
        }
        CTSectPr section = body.getSectPr();
        if(!section.isSetPgSz()){
            section.addNewPgSz();
        }
        CTPageSz pageSize = section.getPgSz();
        pageSize.setW(BigInteger.valueOf(11900));
        pageSize.setH(BigInteger.valueOf(16840));


        XWPFParagraph paragraph1 = document.createParagraph();

        paragraph1.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run1 = paragraph1.createRun();
        run1.setFontSize(18);
        run1.setUnderline(UnderlinePatterns.SINGLE);

        for (int i = 0; i < 28; i++) {
            run1.addBreak();
        }
        run1.setText("RENT AGREEMENT");

        XWPFParagraph paragraph2 = document.createParagraph();
        paragraph2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run2 = paragraph2.createRun();
        run2.setFontSize(12);
        run2.setText("This agreement is made at " + rentAgreement.getExecutionCity() + " on " + rentAgreement.getExecutionDate());
        run2.addBreak();
        run2.setText("BETWEEN");

        for (int i = 0; i < 3; i++) {
            run2.addBreak();
        }

        run2.setText("OWNER");

        for (int i = 0; i < 9; i++) {
            run2.addTab();
        }

        run2.setText("TENANT");

        String pathname = "firstPage.docx";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(pathname));
        document.write(fileOutputStream);
        fileOutputStream.close();

        return pathname;
    }
}
