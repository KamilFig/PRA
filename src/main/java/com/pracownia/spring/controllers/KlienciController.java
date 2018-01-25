package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.services.KlienciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;

@RestController
@RequestMapping("/api")
public class KlienciController {

    @Autowired
    private KlienciService klienciService;

    @RequestMapping(value = "/klienci", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Klienci> list(Model model) {
        return klienciService.listAllKlienci();
    }

    @RequestMapping(value = "/klienci/{page}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Klienci> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return klienciService.listAllKlienciPaging(pageNr, howManyOnPage.orElse(2));
    }
    @RequestMapping(value = "/klienci/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Klienci getByPublicId(@PathVariable("id") Integer publicId) {
        return klienciService.getId(publicId);
    }
    @RequestMapping(value = "/klient", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Klienci getByParamPublicId(@RequestParam("id") Integer publicId) {
        return klienciService.getId(publicId);
    }

    @RequestMapping(value = "/klient", method = RequestMethod.POST)
    public ResponseEntity<Klienci> create(@RequestBody @Valid @NotNull Klienci klienci) {
        klienci.setKlienciId(new Random().nextInt());
        klienciService.saveKlient(klienci);
        return ResponseEntity.ok().body(klienci);
    }
    /**
     * Edit product in database.
     *
     */
    @RequestMapping(value = "/klient", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Klienci klienci) {
        if(!klienciService.checkIfExist(klienci.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            klienciService.saveKlient(klienci);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
    @RequestMapping(value = "/klienci/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        klienciService.deleteKlient(id);
        return new RedirectView("/api/klienci", true);
    }

    }

