package com.pracownia.spring.controllers;

import com.pracownia.spring.entities.Wypozyczenia;
import com.pracownia.spring.entities.Klienci;

import com.pracownia.spring.services.WypozyczeniaService;
import com.pracownia.spring.services.KlienciService;
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
public class WypozyczeniaController {
    @Autowired
    private WypozyczeniaService wypozyczeniaService;
    @Autowired
    private KlienciService klienciService;

    @RequestMapping(value = "/wypozyczenia", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Wypozyczenia> list(Model model) {
        return wypozyczeniaService.listAllWypozyczenia();
    }

    @RequestMapping(value = "/wypozyczenia/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    @ResponseBody
    public Wypozyczenia getByWypozyczeniaId(@PathVariable("id") Integer publicId) {
        return wypozyczeniaService.getWypozyczeniaById(publicId);
    }

    @RequestMapping(value = "/wypozyczenie", method = RequestMethod.POST)
    public ResponseEntity<Wypozyczenia> create(@RequestBody @Valid @NotNull Wypozyczenia wypozyczenia) {
        wypozyczeniaService.saveWypozyczenia(wypozyczenia);
        return ResponseEntity.ok().body(wypozyczenia);
    }

    @RequestMapping(value = "/wypozyczenie", method = RequestMethod.PUT)
    public ResponseEntity<Void> edit(@RequestBody @Valid @NotNull Wypozyczenia wypozyczenia) {
        Wypozyczenia WypozyczenieFromData = wypozyczeniaService.getWypozyczeniaById(wypozyczenia.getRent_id());
        if(Objects.nonNull(WypozyczenieFromData)) {
            wypozyczeniaService.saveWypozyczenia(wypozyczenia);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/wypozyczenie/{id}", method = RequestMethod.DELETE)
    public RedirectView delete(@PathVariable Integer id) {
        wypozyczeniaService.deleteWypozyczenia(id);

        return new RedirectView("/api/wypozyczenie", true);
    }
}
