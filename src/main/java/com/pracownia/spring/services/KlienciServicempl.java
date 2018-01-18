package com.pracownia.spring.services;

import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.repositories.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class KlienciServicempl implements KlienciService {

    @Autowired
    private KlienciRepository klienciRepository;

    @Override
    public Iterable<Klienci> listAllKlienciPaging(Integer pageNr, Integer howManyOnPage) {
        return klienciRepository.findAll(new PageRequest(pageNr,howManyOnPage));
    }

    @Override
    public Iterable<Klienci> listAllKlienci() {
        return klienciRepository.findAll();
    }

    @Override
    public Klienci getId(Integer id) {
        return klienciRepository.findOne(id);
    }

    @Override
    public Klienci saveKlient(Klienci klienci) {
        return klienciRepository.save(klienci);
    }

    @Override
    public void deleteKlient(Integer id) {
        klienciRepository.delete(id);
    }

    @Override
    public Boolean checkIfExist(Integer id) {
        if (klienciRepository.checkIfExist(id) > 0)
            return true;
        else
            return false;
    }


}
