package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.entities.Address;
import com.pracownia.spring.services.KlienciService;
import com.pracownia.spring.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @RequestMapping(value = "/address", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Address> list(Model model) {
        return addressService.listAllAddress();
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Address getByAddressId(@PathVariable("id") Integer publicId) {
        return addressService.getAddressById(publicId);
    }

    @RequestMapping(value = "/addres", method = RequestMethod.POST)
    public ResponseEntity<Address> create(@RequestBody @Valid @NotNull Address address) {
        addressService.saveAddress(address);
        return ResponseEntity.ok().body(address);
    }

    @RequestMapping(value = "/addres", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Address address) {
        Address AddressFromData = addressService.getAddressById(address.getId());
        if(Objects.nonNull(AddressFromData)) {
            addressService.saveAddress(address);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/addres/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        addressService.deleteAddress(id);
        return new RedirectView("/api/addres", true);
    }


}
