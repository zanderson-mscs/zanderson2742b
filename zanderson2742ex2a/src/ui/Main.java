package ui;

import domain.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person person = new Person(101, "Zenessa", "Anderson", "za1");
        Tenant tenant = new Tenant(101, "Zenessa", "Anderson", "za1", LocalDateTime.of(2002,9,25,0,0,0), "111-11-1111",
                "507-111-1111", "Buisness", "Buisnessman", 10000.0, LocalDateTime.of(2010, 10,15,0,0,0));
//        Administrator administrator = new Administrator(101, "Zenessa", "Anderson", "za1",
//                LocalDateTime.now(), "", "", LocalDateTime.now());
        ContractAdministrator contractAdministrator = new ContractAdministrator(101, "Zenessa", "Anderson", "za1", LocalDateTime.of(2000,10,10,0,0,0), "111-11-1111",
                "507-111-1111", LocalDateTime.of(2010,10,10,0,0,0), 400.1);
        HourlyAdministrator hourlyAdministrator = new HourlyAdministrator(101, "Bob", "Duncan", "Bdunc", LocalDateTime.now(), "111-22-2222",
                "507-222-2222", LocalDateTime.now(), 50.0);


        tenant.setEmployer("Beth Nelson");
//        administrator.setFirstName("Gerald");


//        ArrayList<TimeCard> timeCards = new ArrayList<TimeCard>();
        hourlyAdministrator.addTimeCard(LocalDateTime.of(2021, 10, 22, 18, 0),
                LocalDateTime.of(2021, 10, 22, 8, 0));

        hourlyAdministrator.addTimeCard(LocalDateTime.of(2021, 10, 22, 18, 0),
                LocalDateTime.of(2021, 11, 22, 8, 0));
        hourlyAdministrator.addTimeCard(LocalDateTime.of(2021, 10, 22, 18, 0),
                LocalDateTime.of(2021, 12, 22, 8, 0));
        hourlyAdministrator.addTimeCard(LocalDateTime.of(2021, 10, 22, 18, 0),
                LocalDateTime.of(2021, 10, 29, 8, 0));
        hourlyAdministrator.addTimeCard(LocalDateTime.of(2021, 9, 01, 18, 0),
                LocalDateTime.of(2021, 10, 5, 8, 0));


//        ArrayList<Administrator> administrators = new ArrayList<Administrator>();
//        administrators.add(contractAdministrator);
//        administrators.add(hourlyAdministrator);
//
//        for (Administrator a : administrators)
//            System.out.println(a);


        ArrayList<Person> people = new ArrayList<Person>();
        people.add(person);
        people.add(tenant);
        people.add(contractAdministrator);
        people.add(hourlyAdministrator);

        double totalGrossPay = 0.0;

        for (Person p : people) {
            System.out.println(p);
            if (p instanceof Administrator)
                totalGrossPay += ((Administrator) p).calcGrossPay();


            ArrayList<TimeCard> timeCards = hourlyAdministrator.getTimeCards();
            for (TimeCard timeCard : timeCards) {
                System.out.println("/t" + timeCard);
            }

//        ArrayList<Administrator> administrators = new ArrayList<Administrator>();
//        administrators.add(contractAdministrator);
//        administrators.add(hourlyAdministrator);


//        for (Administrator a : administrators)
//            totalGrossPay += a.calcGrossPay();

            System.out.println("Total Payroll: " + String.format("%.2f", totalGrossPay));


        }
    }
}
