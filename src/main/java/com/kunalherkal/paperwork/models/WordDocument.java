package com.kunalherkal.paperwork.models;


import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.math.BigInteger;

public class WordDocument {

    protected void addBreak(XWPFRun run, int times) {
        for (int i = 0; i < times; i++) {
            run.addBreak();
        }
    }

    protected void addTab(XWPFRun run, int times) {
        for (int i = 0; i < times; i++) {
            run.addTab();
        }
    }

    protected void setSize(XWPFDocument document, int width, int height) {
        CTBody body = document.getDocument().getBody();
        if (!body.isSetSectPr()) {
            body.addNewSectPr();
        }
        CTSectPr section = body.getSectPr();
        if (!section.isSetPgSz()) {
            section.addNewPgSz();
        }
        CTPageSz pageSize = section.getPgSz();
        pageSize.setW(BigInteger.valueOf(width));
        pageSize.setH(BigInteger.valueOf(height));
    }
}
