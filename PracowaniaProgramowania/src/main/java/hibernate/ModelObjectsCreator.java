package hibernate;
import hibernate.model.Autor;
import hibernate.model.Wypozyczenia;
import hibernate.model.Klienci;
import hibernate.model.Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.Query;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {

    Klienci k;
    Klienci k2;
    Address address;
    Autor autor;
    Wypozyczenia wypozyczenia;
    Wypozyczenia wypozyczenia2;
    List<Klienci> klient;


    public Klienci getK() {
        return k;
    }

    public void setK(Klienci k) {
        this.k = k;
    }

    public Klienci getK2() {
        return k2;
    }

    public void setK2(Klienci k2) {
        this.k2 = k2;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Wypozyczenia getWypozyczenia() {
        return wypozyczenia;
    }

    public void setWypozyczenia(Wypozyczenia wypozyczenia) {
        this.wypozyczenia = wypozyczenia;
    }

    public Wypozyczenia getWypozyczenia2() {
        return wypozyczenia2;
    }

    public void setWypozyczenia2(Wypozyczenia wypozyczenia2) {
        this.wypozyczenia2 = wypozyczenia2;
    }

    public List<Klienci> getKlient() {
        return klient;
    }

    public void setKlient(List<Klienci> klient) {
        this.klient = klient;
    }

    public void init(){

        //add 1
        Klienci k = new Klienci();
        k.setFirstName("Jan");
        k.setLastName("Polak" + new Random().nextInt());
        k.setPesel(new Random().nextInt());
        // emp.setBirth(jodatime);
        //add 2
        Klienci k2 = new Klienci();
        k2.setFirstName("Roman123");
        k2.setLastName("Polak" + new Random().nextInt());
        k2.setPesel(new Random().nextInt());

        //

        //add address
        Address address = new Address();
        address.setCity("poznan");
        address.setStreet("poznanska");
        address.setNr("1");
        address.setPostcode("99090");

        //add rent
        Wypozyczenia wypozyczenia = new Wypozyczenia();
        wypozyczenia.setPrice(100);
        wypozyczenia.setRent_date("1999-10-10");
        wypozyczenia.setReturn_date("1999-11-10");
        wypozyczenia.setBook_id(1);
        wypozyczenia.setTitle("Calineczka");
        //add rent 2
        Wypozyczenia wypozyczenia2 = new Wypozyczenia();
        wypozyczenia2.setPrice(100);
        wypozyczenia2.setRent_date("1999-10-10");
        wypozyczenia2.setReturn_date("1999-11-10");
        wypozyczenia2.setBook_id(2);
        wypozyczenia2.setTitle("Harry Potter");
        //add author
        Autor autor = new Autor();
        autor.setFirstName("Maciej");
        autor.setLastName("Ziemniewicz");
        autor.setAge(21);

        k.getRent().add(wypozyczenia);
        k.getRent().add(wypozyczenia2);
        k.setAddress(address);
        k2.setAddress(address);
        wypozyczenia.getAuthor().add(autor);

        klient = new ArrayList<Klienci>();
        klient.add(k);
        klient.add(k2);

    }

    public ModelObjectsCreator(){
        init();
    }


}
