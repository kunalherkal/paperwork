package com.kunalherkal.paperwork.models;

import com.kunalherkal.paperwork.models.dto.RentAgreement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;

public class RentAgreementSecondPage implements Creatable {
    private final RentAgreement rentAgreement;

    public RentAgreementSecondPage(RentAgreement rentAgreement) {
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
        pageSize.setH(BigInteger.valueOf(20160));
        pageSize.setW(BigInteger.valueOf(12240));

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
