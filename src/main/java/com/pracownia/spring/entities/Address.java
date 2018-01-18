package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Product entity.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope= com.pracownia.spring.entities.Product.class)
public class Address {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name = "id")
    private int id;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private String city;

    @Column(length = 5, nullable = false)
    private int nr;

    @Column(length = 5)
    private int housenr;

    @Column(length = 5, nullable = false)
    private  String postcode;

    public Address(){}

    public Address(String street,String city, int nr, int housenr, String postcode){
        this.street = street;
        this.city = city;
        this.nr = nr;
        this.housenr = housenr;
        this.postcode = postcode;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getHousenr() {
        return housenr;
    }

    public void setHousenr(int housenr) {
        this.housenr = housenr;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
