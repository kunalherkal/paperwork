package com.kunalherkal.paperwork.services;

import com.kunalherkal.paperwork.models.RentAgreementFirstPage;
import com.kunalherkal.paperwork.models.RentAgreementSecondPage;
import com.kunalherkal.paperwork.models.dto.RentAgreement;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DocumentCreatorService {

    public Map<String, String> create(RentAgreement agreement){
        Map<String, String> map = new HashMap<String, String>();
        try {
            RentAgreementFirstPage firstPage = new RentAgreementFirstPage(agreement);
            String firstPageId = firstPage.create();
            RentAgreementSecondPage secondPage = new RentAgreementSecondPage(agreement);
            String secondPageId = secondPage.create();

            map.put("firstPageId", firstPageId);
            map.put("secondPageId", secondPageId);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
