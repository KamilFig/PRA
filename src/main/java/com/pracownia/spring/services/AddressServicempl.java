package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;
import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.repositories.AddressRepository;
import com.pracownia.spring.repositories.KlienciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public class AddressServicempl implements  AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Iterable<Address> listAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public Address getAddressById(Integer id) {
        return addressRepository.findOne(id);
    }

    @Override
    public Address saveAddress(Address seller) {
        return addressRepository.save(seller);
    }

    @Override
    public void deleteAddress(Integer id) { addressRepository.delete(id);
    }

    @Override
    public Address getByName(String name) {
        return addressRepository.findByName(name);
    }
}
