package ui;

import domain.GDate;

public class Main {
    public static void main(String[] args){
        GDate date1 = new GDate();
        System.out.println("GDate():\t\t\t\t" + date1);
        GDate date2 = new GDate(2000, 01 ,01);
        System.out.println("GDate(2000, 01, 01):\t" + date2);
        GDate date3 = new GDate(date1);
        System.out.println("GDate(date1):\t\t\t" + date3);

        GDate date4 = new GDate(2451545);
        System.out.println("GDate(2451545):\t\t\t" + date4);

        GDate date5 = date4.copy();
        System.out.println("date4.copy:\t\t\t\t" + date5);

        System.out.print(date1);
        System.out.print(date1.equals(date3) ? " = " : " != ");
        System.out.println(date3);

        GDate date6 = new GDate(2000, 02, 14);
        System.out.print(date1);
        System.out.print(date1.equals(date6) ? " = " : " != ");
        System.out.println(date6);


        System.out.print(date1);
        System.out.print(date1.greaterThan(date6) ? " > " : " <= ");
        System.out.println(date6);


        GDate date7 = new GDate(2001, 9, 25);
        System.out.print(date7);
        System.out.print(date7.greaterThan(date1) ? " > " : " <= ");
        System.out.println(date1);

        GDate date8 = new GDate(2001, 01, 01 );

        System.out.print(date7 + " - " + date1 + " = ");
        System.out.print(date7.diff(date1));
        System.out.println();

        System.out.print(date8 + " - " + date1 + " = ");
        System.out.print(date8.diff(date1));
        System.out.println();

        System.out.print(date1 + " + " + "30" + " = ");
        System.out.print(date1.add(60));
        System.out.println();


        System.out.print(date8 + " + " + "30" + " = ");
        System.out.print(date8.add(60));

        System.out.println("Year of: " + date1 + " = " + date1.year());

        System.out.println("Month of: " + date1 + " = " + date1.month());

        System.out.println("Day of: " + date1 + " = " + date1.day());

        System.out.println("JDN of: " + date1 + " = " + date1.julianDay());

    }

}
