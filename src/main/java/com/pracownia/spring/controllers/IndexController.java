package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.entities.Address;
import com.pracownia.spring.services.KlienciService;
import com.pracownia.spring.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.UUID;
import java.util.Random;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {



    @Autowired
    private KlienciService klienciService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index() {
        return "index";
    }


    @RequestMapping(value = "generateModel", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
    public String generateModel() {

        LocalDateTime localtDateAndTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime dateAndTime  = ZonedDateTime.of(localtDateAndTime, zoneId);


        //1 Klient
       Klienci k1 = new Klienci();
        k1.setFirstName("Jan");
        k1.setLastName("Polak");
        k1.setPesel(new Random().nextInt());
        k1.setBirth("1999-10-10");
        k1.setGender("Mezczynza");

        //2 Klient
        Klienci k2 = new Klienci();
        k2.setFirstName("Roman");
        k2.setLastName("Kowalski");
        k2.setPesel(new Random().nextInt());
        k2.setBirth("1996-10-12");
        k2.setGender("Mezczyzna");
        //1 Address
        Address address1 = new Address();
        address1.setCity("Poznan");
        address1.setStreet("poznanska");
        address1.setNr(1);
        address1.setPostcode("99090");
        address1.setHousenr(31);
        //2 Address
        Address address2 = new Address();
        address2.setCity("Wroclaw");
        address2.setStreet("wroclawska");
        address2.setNr(2);
        address2.setPostcode("33033");
        address2.setHousenr(50);



       klienciService.saveKlient(k1);
       klienciService.saveKlient(k2);

       addressService.saveAddress(address1);
       addressService.saveAddress(address2);




        k1.setAddress(address1);         //Klient 1 adress 1
        k2.setAddress(address2);         //Klient 2 adress 2



        klienciService.saveKlient(k1);
        klienciService.saveKlient(k2);
        return "Model Generated";
    }

}
