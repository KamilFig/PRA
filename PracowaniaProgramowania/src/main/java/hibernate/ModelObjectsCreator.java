package hibernate;
import hibernate.model.Address;
import hibernate.model.Klienci;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Helper class which provides methods to create instances of hibernate.model classes
 */
public class ModelObjectsCreator {

    Klienci emp;
    Klienci emp2;
    Address address;

    List<Klienci> employees;

    public Klienci getEmp() {
        return emp;
    }

    public Klienci getEmp2() {
        return emp2;
    }

    public Address getAddress() {
        return address;
    }

    public List<Klienci> getEmployees() {
        return employees;
    }

    public void init(){
        emp = new Klienci();
        emp.setFirstName("Jan");
        emp.setLastName("Polak123" + new Random().nextInt());
        emp.setPesel(Math.abs(new Random().nextInt()));
        emp.setGender("m");

        emp2 = new Klienci();
        emp2.setFirstName("Roman");
        emp2.setLastName("Polak" + new Random().nextInt());
        emp2.setPesel(Math.abs(new Random().nextInt()));

        //add address
        Address address = new Address();
        address.setCity("poznan");
        address.setStreet("poznanska");
        address.setNr("1");
        address.setPostcode("99090");

        emp.setAddress(address);
        emp2.setAddress(address);

        employees = new ArrayList<Klienci>();
        employees.add(emp);
        employees.add(emp2);

    }

    public ModelObjectsCreator(){
        init();
    }


}
