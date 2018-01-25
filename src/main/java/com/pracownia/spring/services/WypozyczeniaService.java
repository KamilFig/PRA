package com.pracownia.spring.services;

import com.pracownia.spring.entities.Wypozyczenia;


public interface WypozyczeniaService {

    Iterable<Wypozyczenia> listAllWypozyczenia();

    Wypozyczenia getWypozyczeniaById(Integer id);

    Wypozyczenia saveWypozyczenia(Wypozyczenia wypozyczenia);

    void deleteWypozyczenia(Integer id);
}
