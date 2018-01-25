package com.pracownia.spring.services;

import org.springframework.stereotype.Service;

import com.pracownia.spring.entities.Wypozyczenia;
import com.pracownia.spring.repositories.WypozyczeniaRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WypozyczeniaServicempl implements WypozyczeniaService {
    @Autowired
    private WypozyczeniaRepository wypozyczeniaRepository;

    @Override
    public Iterable<Wypozyczenia> listAllWypozyczenia() {
        return wypozyczeniaRepository.findAll();
    }

    @Override
    public Wypozyczenia getWypozyczeniaById(Integer id) {
        return wypozyczeniaRepository.findOne(id);
    }

    @Override
    public Wypozyczenia saveWypozyczenia(Wypozyczenia klient) {
        return wypozyczeniaRepository.save(klient);
    }

    @Override
    public void deleteWypozyczenia(Integer id) { wypozyczeniaRepository.delete(id);
    }

}
