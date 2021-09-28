package ui;

import domain.GDate;
import domain.Invoice;
import domain.LineItem;

public class Main {
    public static void main(String[] args){
        GDate date1 = new GDate(2019, 9, 1);
        GDate date2 = new GDate(2019,9,11);

        Invoice invoice1 = new Invoice(1, date1, date2);

        invoice1.addLineItem(new LineItem(1.0, "description 1"));
        invoice1.addLineItem(new LineItem(2.0, "description 2"));
        invoice1.addLineItem(new LineItem(3.0, "description 3"));
        invoice1.addLineItem(new LineItem(4.0, "description 4"));

        System.out.println("invoice1.total() = " + invoice1.total());
    }
}
