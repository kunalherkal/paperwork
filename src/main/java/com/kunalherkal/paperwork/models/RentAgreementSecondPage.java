package com.kunalherkal.paperwork.models;

import com.kunalherkal.paperwork.models.dto.Address;
import com.kunalherkal.paperwork.models.dto.Person;
import com.kunalherkal.paperwork.models.dto.RentAgreement;
import com.kunalherkal.paperwork.utils.Constants;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class RentAgreementSecondPage extends WordDocument implements Creatable {
    private final RentAgreement rentAgreement;
    private final int height = 20160;
    private final int width = 12240;

    public RentAgreementSecondPage(RentAgreement rentAgreement) {
        this.rentAgreement = rentAgreement;
    }

    /*
    XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(18);
        run.setUnderline(UnderlinePatterns.SINGLE);
        run.setText("RENT AGREEMENT");
    * */

    @Override
    public String create() throws IOException {
        XWPFDocument document = new XWPFDocument();
        setSize(document, width, height);

        for (Person owner: rentAgreement.getOwners()) {
            setName(document, owner);
            setAddress(document, owner);
        }

        setIntro(document, Constants.OWNER, "FIRST");
        setAND(document);

        for (Person tenant: rentAgreement.getTenants()) {
            setName(document, tenant);
            setAddress(document, tenant);
        }
        setIntro(document, Constants.TENANT, "SECOND");

        String pathname = "secondPage.docx";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(pathname));
        document.write(fileOutputStream);
        fileOutputStream.close();
        return pathname;
    }

    private void setAND(XWPFDocument document) {
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(12);
        run.setText("AND");
        run.addBreak();
    }

    private void setIntro(XWPFDocument document, String role, String part) {
        String text = "HEREINAFTER referred to as the \""+ role + "\" (Which expression, unless repugnant to the context or meaning thereof, shall mean and include his/her/their legal heirs, executors, administrators & assign etc.) of the " + part + " PART.";
        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(12);
        run.setText(text);
        run.addBreak();
    }

    private void setAddress(XWPFDocument document, Person person) {
        String occupation = WordUtils.capitalizeFully(person.getOccupation());
        Address address = person.getAddress();
        String line1 = WordUtils.capitalizeFully(address.getLine1());
        String line2 = WordUtils.capitalizeFully(address.getLine2());
        String city = WordUtils.capitalizeFully(address.getCity());
        String state = WordUtils.capitalizeFully(address.getState());
        String pinCode = address.getPincode();
        String phoneNumber = person.getPhoneNumber();

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(12);

        run.setText("Age: " + person.getAge() + ", Occupation: " + occupation + ",");
        run.addBreak();

        run.setText("Address: " + line1 + ",");
        run.addBreak();

        run.setText(line2 + ",");
        run.addBreak();

        run.setText(city + ", " + state + ", PIN: " + pinCode + ".");
        run.addBreak();

        run.setText("Phone No: " + phoneNumber);
        run.addBreak();
    }

    private void setName(XWPFDocument document, Person person) {
        String name = person.getFullName().toUpperCase();

        XWPFParagraph paragraph = document.createParagraph();
        paragraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun run = paragraph.createRun();
        run.setFontSize(14);
        run.setBold(true);
        run.setText(name);
    }
}
