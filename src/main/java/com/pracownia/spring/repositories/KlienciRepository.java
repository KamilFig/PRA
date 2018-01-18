package com.pracownia.spring.repositories;

import com.pracownia.spring.entities.Klienci;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

public interface KlienciRepository extends CrudRepository<Klienci, Integer>, PagingAndSortingRepository<Klienci, Integer> {

    Klienci findByKlientId(String productId);

    @Query("select count(*) from Klienci k where k.id = ?1")
    Integer checkIfExist(Integer id);
}
