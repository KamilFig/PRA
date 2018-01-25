package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Entity
@Table(name = "CUSTOMERS", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"first_name","last_name"})})
public class Klienci {


    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column
    private int klienciId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "PESEL", nullable = false, unique = true)
    private int pesel;

    //  @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth")
    private String birth;

    @Column(name = "gender")
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Address_ID", referencedColumnName = "id")
    Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Wypozyczenia> rent = new ArrayList<>();
    public List<Wypozyczenia> getRent() {return rent; }

    public void setRent(List<Wypozyczenia> rent) {this.rent = rent; }

    public Klienci() {}

    public Klienci(int klienciId, String firstName, String lastName, int pesel, String birth, String gender) {
       this.klienciId = klienciId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birth = birth;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKlienciId() {
        return klienciId;
    }

    public void setKlienciId(int klienciId) {
        this.klienciId = klienciId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPesel() {
        return pesel;
    }

    public void setPesel(int pesel) {
        this.pesel = pesel;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
