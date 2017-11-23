package hibernate;

import hibernate.model.Address;
import hibernate.model.Klienci;
import hibernate.model.Wypozyczenia;
import hibernate.model.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
            Klienci emp = new Klienci();
            emp.setFirstName("Jan");
            emp.setLastName("Polak" + new Random().nextInt());
            emp.setPesel(new Random().nextInt());

            //add 2
            Klienci emp2 = new Klienci();
            emp2.setFirstName("Roman123");
            emp2.setLastName("Polak" + new Random().nextInt());
            emp2.setPesel(new Random().nextInt());

            //save 2
            entityManager.persist(emp2);

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

            emp.getRent().add(wypozyczenia);
            emp.getRent().add(wypozyczenia2);
            emp.setAddress(address);
            emp2.setAddress(address);
            wypozyczenia.getAuthor().add(autor);

            entityManager.persist(address);
            entityManager.persist(emp);
            entityManager.persist(wypozyczenia);
            entityManager.persist(autor);





            entityManager.getTransaction().commit();

            System.out.println("Done");

            entityManager.close();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
        } finally {
            entityManagerFactory.close();
        }

    }




}