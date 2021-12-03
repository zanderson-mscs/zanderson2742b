package domain;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class DbContext {
    private static int previousInvoiceId = 1000;
    private static int previousLineItemId = 10000;

    public static int getNextInvoiceId() { return ++previousInvoiceId; }

    public static int getNextLineItemId(){ return ++previousLineItemId; }

    public static ArrayList<Invoice> getInvoices() {
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        LocalDateTime date1 = LocalDateTime.of(2019, Month.SEPTEMBER, 1,0,0);
        LocalDateTime date2 = LocalDateTime.of(2019, Month.SEPTEMBER, 11,0,0);

        Invoice invoice1 = (new Invoice(1, date1, date2, null));


        invoice1.addLineItem(new LineItem(1.0, "description 1"));
        invoice1.addLineItem(new LineItem(2.0, "description 2"));
        invoice1.addLineItem(new LineItem(3.0, "description 3"));
        invoice1.addLineItem(new LineItem(4.0, "description 4"));

        invoices.add(invoice1.copy());

        Invoice invoice2 = new Invoice(2,
                LocalDateTime.of(2019, Month.OCTOBER, 15,0,0),
                LocalDateTime.of(2019, Month.NOVEMBER, 1,0,0 ),
                null
        );
        invoice1.addLineItem(new LineItem(5.0, "description 5"));
        invoice1.addLineItem(new LineItem(6.0, "description 6"));
        invoice1.addLineItem(new LineItem(7.0, "description 7"));
        invoice1.addLineItem(new LineItem(8.0, "description 8"));

        return invoices;
    }

    public static ArrayList<Apartment> getApartments() {

        ArrayList<Person> people = DbContext.getPeople();

        ArrayList<Apartment> apartments = new ArrayList<Apartment>();
        Apartment apartment = new Apartment();
        apartment.setApartmentId(101);
        apartment.setApartmentNum("101");
        apartment.setSquareFeet(1001);
        apartment.setBathrooms(1);
        apartment.setPrice(1000.01);
        ArrayList<Invoice> invoices = getInvoices();
        for (Invoice invoice : invoices) {
            apartment.addInvoice(invoice);
        }
        apartments.add(apartment);

        apartment.setAdministrator(people.get(0));
        apartment.setTenant(people.get(1));

        apartment = new Apartment();
        apartment.setApartmentId(102);
        apartment.setApartmentNum("102");
        apartment.setSquareFeet(1002);
        apartment.setBathrooms(2);
        apartment.setPrice(1000.02);
        invoices = getInvoices();
        for (Invoice invoice : invoices) {
            apartment.addInvoice(invoice);
        }
        apartments.add(apartment);
        apartment.setAdministrator(people.get(0));
        apartment.setTenant(people.get(2));

        return apartments;
    }

//    public static ArrayList<Person> getPeople(){
//        ArrayList<Person> people = new ArrayList<Person>();
//        Person person = new Person();
//        person.setPersonId(1);
//        person.setFirstName("Jane");
//        person.setLastName("Doe");
//        person.setUserName("JaneDoe");
//        person.setUpdated();
//
//        return people;
//    }

    public static ArrayList<Person> getPeople(){
        ArrayList<Person> people = new ArrayList<Person>();
        Person person1 = new Person();
        person1.setPersonId(1);
        person1.setFirstName("Jane");
        person1.setLastName("Doe");
        person1.setUserName("JaneDoe");
        person1.setUpdated();

        people.add(person1);

        Person person2 = new Person();
        person2.setPersonId(2);
        person2.setFirstName("John");
        person2.setLastName("Doe");
        person2.setUserName("JohnDoe");
        person2.setUpdated();

        people.add(person2);

        Person person3 = new Person();
        person3.setPersonId(3);
        person3.setFirstName("Michael");
        person3.setLastName("Darr");
        person3.setUserName("MikeyD");
        person3.setUpdated();

        people.add(person3);

        Person person4 = new Person();
        person4.setPersonId(4);
        person4.setFirstName("Paul");
        person4.setLastName("Roy");
        person4.setUserName("PaRo");
        person4.setUpdated();

        people.add(person4);

        Person person5 = new Person();
        person5.setPersonId(5);
        person5.setFirstName("Mary");
        person5.setLastName("Beth");
        person5.setUserName("SparkleKitten");
        person5.setUpdated();

        people.add(person5);

        return people;
    }

}
