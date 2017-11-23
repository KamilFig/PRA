package hibernate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import hibernate.model.Address;
import hibernate.model.Klienci;
import hibernate.model.Wypozyczenia;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class JacksonSerialization {

    final static Logger logger = Logger.getLogger(JacksonSerialization.class);

   /* public static void serializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);;

        //Create objects to serialize
        ModelObjectsCreator objectsCreator = new ModelObjectsCreator();
        Klienci employee = objectsCreator.getEmp();

        //Serialize to file and string
        mapper.writeValue(new File("result." + fileSuffix), employee);
        String jsonString = mapper.writeValueAsString(employee);
        logger.info("Printing serialized original object " + fileSuffix);
        System.out.println(jsonString);

        //Deserialize from file
        Klienci deserializedEmployee = mapper.readValue(
                new File("result." + fileSuffix), Klienci.class);



        //Serialize back
        mapper.writeValue(new File("result-modified." + fileSuffix), deserializedEmployee);
        String modifiedJsonString = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Printing serialized modified object " + fileSuffix);
        System.out.println(modifiedJsonString);

        //Serialize generic List
        List<Klienci> employees = objectsCreator.getEmployees();
        String employeesListSerialized = mapper.writeValueAsString(employees);
        logger.info("Printing serialized employees list " + fileSuffix);
        System.out.println(employeesListSerialized);
    }
    */
    public static void deserializeDemo(ObjectMapper mapper, String fileSuffix) throws IOException {
        //Set mapper to pretty-print
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JodaModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        //Deserialized employee object from klienci.* file in resources
        InputStream employeeIs = JacksonSerialization.class.getClassLoader().
                getResourceAsStream("klienci1." + fileSuffix);
        Klienci deserializedEmployee = mapper.readValue(employeeIs, Klienci.class);
        String modifiedSerialzied = mapper.writeValueAsString(deserializedEmployee);
        logger.info("Odczyt" + fileSuffix);
        System.out.println(modifiedSerialzied);

        System.out.println("Start");

        EntityManager entityManager = null;

        EntityManagerFactory entityManagerFactory = null;

        try {

            entityManagerFactory = Persistence.createEntityManagerFactory("hibernate-dynamic");

            entityManager = entityManagerFactory.createEntityManager();

            entityManager.getTransaction().begin();

            //add 1
            Klienci k = new Klienci();
            k.setFirstName(deserializedEmployee.getFirstName());
            k.setLastName(deserializedEmployee.getLastName());
            k.setPesel(deserializedEmployee.getPesel());

            k.setAddress(deserializedEmployee.getAddress());

            Address address = new Address();
            address.setCity(deserializedEmployee.getAddress().getCity());
            address.setStreet(deserializedEmployee.getAddress().getStreet());
            address.setNr(deserializedEmployee.getAddress().getHousenr());
            address.setPostcode(deserializedEmployee.getAddress().getPostcode());


            entityManager.persist(address);
            entityManager.persist(k);



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

    public static void main(String[] args) throws IOException {


        ObjectMapper jsonMapper = new ObjectMapper();
       // serializeDemo(jsonMapper, "json");
        deserializeDemo(jsonMapper, "json");





      /*  ObjectMapper xmlMapper = new XmlMapper();
        serializeDemo(xmlMapper, "xml");
        deserializeDemo(xmlMapper, "xml");
*/
    }
}