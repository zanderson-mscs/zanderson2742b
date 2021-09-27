package ui;

import domain.GDate;
import domain.Invoice;
import domain.LineItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class InvoiceController {
    @FXML
    private TextField invoiceIdTextField;
    @FXML
    private TextField statusTextField;
    @FXML
    private TextField invoiceDateTextField;
    @FXML
    private TextField dueDateTextField;
    @FXML
    private Button loadBtn;

    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();

    public InvoiceController() {
        GDate date1 = new GDate(2019, 9, 1);
        GDate date2 = new GDate(2019,9,11);

        Invoice invoice1 = (new Invoice(1, date1, date2));


        invoice1.addLineItem(new LineItem(1.0, "description 1"));
        invoice1.addLineItem(new LineItem(2.0, "description 2"));
        invoice1.addLineItem(new LineItem(3.0, "description 3"));
        invoice1.addLineItem(new LineItem(4.0, "description 4"));

        this.invoices.add(invoice1);

        Invoice invoice2 = new Invoice(invoice1);
        ArrayList<LineItem> lineItems = invoice1.getLineItems();
        for (LineItem lineItem : lineItems){
            invoice2.addLineItem(lineItem);
        }
        this.invoices.add(invoice2);

    }

    @FXML
    private void loadBtnClicked(ActionEvent actionEvent) {
        Invoice invoice = this.invoices.get(0);
        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
        this.statusTextField.setText(Integer.toString(invoice.getStatus()));
        this.invoiceDateTextField.setText((invoice.getInvoiceDate()).toString());
        this.dueDateTextField.setText((invoice.getDueDate()).toString());
    }

    @FXML
    private void loadBtn2Clicked(ActionEvent actionEvent) {
        Invoice invoice = this.invoices.get(1);
        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
        this.statusTextField.setText(Integer.toString(invoice.getStatus()));
        this.invoiceDateTextField.setText((invoice.getInvoiceDate()).toString());
        this.dueDateTextField.setText((invoice.getDueDate()).toString());
    }

    @FXML
    protected void initialize(){
        Invoice invoice = this.invoices.get(0);
        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
        this.statusTextField.setText(Integer.toString(invoice.getStatus()));
        this.invoiceDateTextField.setText((invoice.getInvoiceDate()).toString());
        this.dueDateTextField.setText((invoice.getDueDate()).toString());
    }


}
