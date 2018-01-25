package com.pracownia.spring.services;

import com.pracownia.spring.entities.Klienci;

public interface KlienciService {

    Iterable<Klienci> listAllKlienci();

    Klienci getId(Integer id);

    Klienci saveKlient(Klienci klienci);

    void deleteKlient(Integer id);


    Boolean checkIfExist(Integer id);

    public Iterable<Klienci> listAllKlienciPaging(Integer pageNr, Integer howManyOnPage);
}
