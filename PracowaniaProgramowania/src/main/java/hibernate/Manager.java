package hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Address;
import hibernate.model.Klienci;
import hibernate.model.Wypozyczenia;
import hibernate.model.Autor;
import hibernate.queries.Queries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Random;

class Manager {

    public static void main(String[] args) {

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            //add 1
            Klienci k1 = new Klienci();
            k1.setFirstName("Jan");
            k1.setLastName("Polak");
            k1.setPesel(new Random().nextInt());
            k1.setBirth("1999-10-10");
            k1.setGender("Mezczynza");
            //add 2
            Klienci k2 = new Klienci();
            k2.setFirstName("Roman");
            k2.setLastName("Kowalski");
            k2.setPesel(new Random().nextInt());
            k2.setBirth("1996-10-12");
            k2.setGender("Mezczyzna");
            //save 2
            entityManager.persist(k2);

            //add address
            Address address = new Address();
            address.setCity("Poznan");
            address.setStreet("poznanska");
            address.setNr(1);
            address.setPostcode("99090");
            address.setHousenr(31);
            //add address2
            Address address2 = new Address();
            address2.setCity("Wroclaw");
            address2.setStreet("wroclawska");
            address2.setNr(2);
            address2.setPostcode("33033");
            address2.setHousenr(50);
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
            //add rent 3
            Wypozyczenia wypozyczenia3 = new Wypozyczenia();
            wypozyczenia3.setPrice(50);
            wypozyczenia3.setRent_date("2017-10-10");
            wypozyczenia3.setReturn_date("2017-12-10");
            wypozyczenia3.setBook_id(9);
            wypozyczenia3.setTitle("Hobbit");
            //add author
            Autor autor = new Autor();
            autor.setFirstName("Hans Christian");
            autor.setLastName("Andersen");
            autor.setAge(60);
            //add author2
            Autor autor2 = new Autor();
            autor2.setFirstName("J.K.");
            autor2.setLastName("Rowling");
            autor2.setAge(30);
            //add author3
            Autor autor3 = new Autor();
            autor3.setFirstName("Barry");
            autor3.setLastName("Denenberg");
            autor3.setAge(50);
            //add author4
            Autor autor4 = new Autor();
            autor4.setFirstName("John Ronald Reuel ");
            autor4.setLastName("Tolkien");
            autor4.setAge(80);

            k1.getRent().add(wypozyczenia);  //Klient 1 wypozycza
            k1.getRent().add(wypozyczenia2); //Klient 1 wypozyczenie2

            k1.setAddress(address);         //Klient 1 adress
            k2.setAddress(address2);        //Klient 2 adress 2

            wypozyczenia.getAuthor().add(autor); //Ksiazka 1 autor
            wypozyczenia2.getAuthor().add(autor2); // Ksiazka 2 autorow
            wypozyczenia2.getAuthor().add(autor3);
            wypozyczenia3.getAuthor().add(autor4); //Ksiazka 1 autor

            entityManager.persist(address);
            entityManager.persist(k1);
            entityManager.persist(wypozyczenia);
            entityManager.persist(autor);


            entityManager.getTransaction().commit();

            System.out.println("Done");

            changePrince(entityManager);
            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }


    }
  static void changeFirstGuyToKamil(EntityManager entityManager) {

        Query query = entityManager.createQuery("SELECT k FROM Klienci k");
        List<Klienci> klienci = new Queries(entityManager).getAllEmployeeByPage(1);

        klienci.get(0).setFirstName("Kamil"); //Zmiana imienie 1 klienta na Kamil
        System.out.println();

    }
    static void changePrince(EntityManager entityManager) {

        Query query1 = entityManager.createQuery("SELECT k FROM Wypozyczenia k");
        List<Wypozyczenia> wypoz = new Queries(entityManager).BlacFriday(100);
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            String cos = objectMapper.writeValueAsString(wypoz);
            System.out.println("Dzialalalalallala " + cos);
        }
      catch (Exception e) {
            e.printStackTrace();
        }
        wypoz.get(0).setPrice(50); //Zmiana ceny

    }
}