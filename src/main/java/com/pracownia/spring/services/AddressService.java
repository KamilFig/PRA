package com.pracownia.spring.services;

import com.pracownia.spring.entities.Address;

public interface AddressService {

    Iterable<Address> listAllAddress();

    Address getAddressById(Integer id);

    Address saveAddress(Address address);

    void deleteAddress(Integer id);


}
