package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Klienci;
import com.pracownia.spring.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository  extends CrudRepository<Address, Integer> {

    Address findByName(String name);
}
