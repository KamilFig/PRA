package hibernate.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "RENT", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"rent_id"})})
public class Wypozyczenia {

    @Id
    @GeneratedValue
    @Column(name = "rent_id")
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "rent_date")
    private String rent_date;

    @Column(name = "return_date")
    private String return_date;

  /*  @ManyToOne
    @JoinColumn(name="id")
    private Klienci klient;
   */
    public Wypozyczenia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


}
