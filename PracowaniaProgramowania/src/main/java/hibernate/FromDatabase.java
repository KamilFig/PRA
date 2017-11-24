package hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Address;
import hibernate.model.Klienci;
import hibernate.model.Wypozyczenia;
import hibernate.model.Autor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

class FromDatabase {

    public static void main (String args[])
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");
        entityManager = entityManagerFactory.createEntityManager();

       Query query1 = entityManager.createQuery("select kl from Klienci kl ");

        ObjectMapper jsonKlienci = new ObjectMapper();
        jsonKlienci.enable(SerializationFeature.INDENT_OUTPUT);
        jsonKlienci.registerModule(new JodaModule());
        jsonKlienci.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        XmlMapper xmlKlienci = new XmlMapper();
        xmlKlienci.enable(SerializationFeature.INDENT_OUTPUT);
        xmlKlienci.registerModule(new JodaModule());
        xmlKlienci.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String klientJsonString;
        String klientXmlString;

        try {

            //Zapis Json
            klientJsonString=jsonKlienci.writeValueAsString(query1.getResultList());

            FileWriter fileWriter1=new FileWriter("Klienci.json");
            BufferedWriter bufferedWriter1=new BufferedWriter(fileWriter1);
            bufferedWriter1.write(klientJsonString);
            bufferedWriter1.close();
            fileWriter1.close();

            //Zapis xml
            klientXmlString=xmlKlienci.writeValueAsString(query1.getResultList());
            FileWriter fileWriter2=new FileWriter("Klienci.xml");
            BufferedWriter bufferedWriter2=new BufferedWriter(fileWriter2);
            bufferedWriter2.write(klientXmlString);
            bufferedWriter2.close();
            fileWriter2.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

       Query query2 = entityManager.createQuery("SELECT ad FROM Address ad");

        ObjectMapper jsonAddress = new ObjectMapper();
        jsonAddress.enable(SerializationFeature.INDENT_OUTPUT);
        jsonAddress.registerModule(new JodaModule());
        jsonAddress.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        XmlMapper xmlAddress = new XmlMapper();
        xmlAddress.enable(SerializationFeature.INDENT_OUTPUT);
        xmlAddress.registerModule(new JodaModule());
        xmlAddress.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String addressJsonString;
        String addressXmlString;

        try {

            addressJsonString=jsonAddress.writeValueAsString(query2.getResultList());
            FileWriter fileWriter3=new FileWriter("Address.json");
            BufferedWriter bufferedWriter3=new BufferedWriter(fileWriter3);
            bufferedWriter3.write(addressJsonString);
            bufferedWriter3.close();
            fileWriter3.close();

            addressXmlString=xmlAddress.writeValueAsString(query2.getResultList());
            FileWriter fileWriter4=new FileWriter("Address.xml");
            BufferedWriter bufferedWriter4=new BufferedWriter(fileWriter4);
            bufferedWriter4.write(addressXmlString);
            bufferedWriter4.close();
            fileWriter4.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
       Query query3 = entityManager.createQuery("SELECT wy FROM Wypozyczenia wy");

        ObjectMapper jsonWypozyczenia = new ObjectMapper();
        jsonWypozyczenia.enable(SerializationFeature.INDENT_OUTPUT);
        jsonWypozyczenia.registerModule(new JodaModule());
        jsonWypozyczenia.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        XmlMapper xmlWypozyczenia = new XmlMapper();
        xmlWypozyczenia.enable(SerializationFeature.INDENT_OUTPUT);
        xmlWypozyczenia.registerModule(new JodaModule());
        xmlWypozyczenia.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String wypozyczeniaJsonString;
        String wypozyczeniaXmlString;

        try {

            wypozyczeniaJsonString=jsonWypozyczenia.writeValueAsString(query3.getResultList());
            FileWriter fileWriter5=new FileWriter("Wypozyczenia.json");
            BufferedWriter bufferedWriter5=new BufferedWriter(fileWriter5);
            bufferedWriter5.write(wypozyczeniaJsonString);
            bufferedWriter5.close();
            fileWriter5.close();

            wypozyczeniaXmlString=xmlWypozyczenia.writeValueAsString(query1.getResultList());
            FileWriter fileWriter6=new FileWriter("Wypozyczenia.xml");
            BufferedWriter bufferedWriter6=new BufferedWriter(fileWriter6);
            bufferedWriter6.write(wypozyczeniaXmlString);
            bufferedWriter6.close();
            fileWriter6.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

       Query  query4 = entityManager.createQuery("SELECT au FROM Autor au");

        ObjectMapper jsonAutor = new ObjectMapper();
        jsonAutor.enable(SerializationFeature.INDENT_OUTPUT);
        jsonAutor.registerModule(new JodaModule());
        jsonAutor.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        XmlMapper xmlAutor = new XmlMapper();
        xmlAutor.enable(SerializationFeature.INDENT_OUTPUT);
        xmlAutor.registerModule(new JodaModule());
        xmlAutor.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        String autorJsonString;
        String autortXmlString;

        try {

            autorJsonString=jsonAutor.writeValueAsString(query4.getResultList());
            FileWriter fileWriter7=new FileWriter("Autor.json");
            BufferedWriter bufferedWriter7=new BufferedWriter(fileWriter7);
            bufferedWriter7.write(autorJsonString);
            bufferedWriter7.close();
            fileWriter7.close();

            autortXmlString=xmlAutor.writeValueAsString(query1.getResultList());
            FileWriter fileWriter8=new FileWriter("Autor.xml");
            BufferedWriter bufferedWriter8=new BufferedWriter(fileWriter8);
            bufferedWriter8.write(autortXmlString);
            bufferedWriter8.close();
            fileWriter8.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        entityManager.close();

        entityManagerFactory.close();
    }





}