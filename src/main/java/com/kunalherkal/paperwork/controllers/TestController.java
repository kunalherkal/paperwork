package com.kunalherkal.paperwork.controllers;

import com.kunalherkal.paperwork.models.dto.Address;
import com.kunalherkal.paperwork.models.dto.Person;
import com.kunalherkal.paperwork.models.dto.Property;
import com.kunalherkal.paperwork.models.dto.RentAgreement;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {

    @RequestMapping(value = "/json", method = RequestMethod.GET)
    public RentAgreement getJson(@RequestParam(value = "name", defaultValue = "") String name) throws IOException {
        Address ownerAddress = new Address("address line 1", "address line 1", "Pune", "Maharashtra", "411028");
        Person owner = new Person("Owner Owner", 25, "male", "service", "9087654321", "something@gmail.com", "123412341234", "123456789", ownerAddress);
        Person tenant = new Person("Tenant Tenant", 25, "famale", "business", "9087654321", "something@gmail.com", "123412341234", "123456789", ownerAddress);
        Person witness = new Person("Witness Witness", 25, "male", "witnessing", "9087654321", "something@gmail.com", "123412341234", "123456789", ownerAddress);
        Property property = new Property("apartment", 500.00, "residential", "Some Niwas", "42", ownerAddress);

        List<Person> owners = new ArrayList<Person>();
        owners.add(owner);
        List<Person> tenants = new ArrayList<Person>();
        tenants.add(tenant);
        List<Person> witnesses = new ArrayList<Person>();
        witnesses.add(witness);
        RentAgreement agreement = new RentAgreement("01-01-2017", "Pune", 11, "01-02-2017", 10000, 5000, 2, owners, tenants, witnesses, property);
        return agreement;
    }

    @PostMapping(value = "/json", consumes = "application/json")
    public String post(@RequestBody RentAgreement agreement) throws IOException {
        return agreement.toString();
    }
}
