package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Product;
import com.pracownia.spring.entities.Seller;
import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.entities.Address;
import com.pracownia.spring.services.KlienciService;
import com.pracownia.spring.services.ProductService;
import com.pracownia.spring.services.SellerService;
import com.pracownia.spring.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.Random;

/**
 * Homepage controller.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SellerService sellerService;

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

        Product p1 = new Product(UUID.randomUUID().toString(),"Jajko", new BigDecimal(2.50), dateAndTime.plusDays(7));
        Product p2 = new Product(UUID.randomUUID().toString(),"Masło", new BigDecimal(3.50), dateAndTime.plusDays(7));
        Product p3 = new Product(UUID.randomUUID().toString(),"Mąka", new BigDecimal(1.50), dateAndTime.plusDays(7));
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

        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);

       klienciService.saveKlient(k1);
       klienciService.saveKlient(k2);

       addressService.saveAddress(address1);
       addressService.saveAddress(address2);

        Seller seller = new Seller("Biedra", "Poznan", Arrays.asList(p1.getProductId(), p2.getProductId(), p3.getProductId()));
        Seller seller2 = new Seller("Lidl", "Krosno", Arrays.asList(p1.getProductId(), p2.getProductId()));

        sellerService.saveSeller(seller);
        sellerService.saveSeller(seller2);

        p1.getSellers().add(seller);
        p2.getSellers().add(seller);
        p3.getSellers().add(seller);
        p1.getSellers().add(seller2);
        p2.getSellers().add(seller2);

        k1.setAddress(address1);         //Klient 1 adress 1
        k2.setAddress(address2);         //Klient 2 adress 2

        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);

        klienciService.saveKlient(k1);
        klienciService.saveKlient(k2);
        return "Model Generated";
    }

}
