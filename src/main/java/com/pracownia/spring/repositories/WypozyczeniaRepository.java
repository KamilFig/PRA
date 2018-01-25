package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Wypozyczenia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface WypozyczeniaRepository extends CrudRepository<Wypozyczenia, Integer>  {
}
