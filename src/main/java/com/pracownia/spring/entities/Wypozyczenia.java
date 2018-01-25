package com.pracownia.spring.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Entity
@Table(name = "RENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"rent_id"})})
public class Wypozyczenia {
    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private int rent_id;

    @Column(name = "book_id")
    private int book_id;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private int price;

    @Column(name = "rent_date")
    private String rent_date;

    @Column(name = "return_date")
    private String return_date;

    public Wypozyczenia(int book_id, String title, int price, String rent_date, String return_date) {
        this.book_id = book_id;
        this.title = title;
        this.price = price;
        this.rent_date = rent_date;
        this.return_date = return_date;
    }

    public Wypozyczenia() {
    }


    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }


    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
