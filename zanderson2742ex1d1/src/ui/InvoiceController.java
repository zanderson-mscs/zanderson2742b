package ui;

import domain.DbContext;
import domain.Invoice;
import domain.LineItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class InvoiceController {
    private ArrayList<Invoice> invoices = new ArrayList<Invoice>();
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


    @FXML
    private ComboBox invoicesComboBox;
    @FXML
    private TextField descriptionTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private ListView lineItemsListView;
    @FXML
    private Button saveInvoiceBtn;
    @FXML
    private Button saveLineItemBtn;
    @FXML
    private TextField totalTextField;
    @FXML
    private Button addLineItemBtn;
    @FXML
    private Button deleteLineItemBtn;

    public InvoiceController() {
//       this.invoices = DbContext.getInvoices();
//        GDate date1 = new GDate(2019, 9, 1);
//        GDate date2 = new GDate(2019,9,11);
//
//        Invoice invoice1 = (new Invoice(1, date1, date2));
//
//
//        invoice1.addLineItem(new LineItem(1.0, "description 1"));
//        invoice1.addLineItem(new LineItem(2.0, "description 2"));
//        invoice1.addLineItem(new LineItem(3.0, "description 3"));
//        invoice1.addLineItem(new LineItem(4.0, "description 4"));
//
//        this.invoices.add(invoice1);
//
//        Invoice invoice2 = new Invoice(2,
//                new GDate(2019, 10, 15),
//                new GDate(2019, 11, 1)
//        );
//        invoice1.addLineItem(new LineItem(5.0, "description 5"));
//        invoice1.addLineItem(new LineItem(6.0, "description 6"));
//        invoice1.addLineItem(new LineItem(7.0, "description 7"));
//        invoice1.addLineItem(new LineItem(8.0, "description 8"));

//        ArrayList<LineItem> lineItems = invoice1.getLineItems();
//        for (LineItem lineItem : lineItems){
//            invoice2.addLineItem(lineItem);
//        }
//        this.invoices.add(invoice2);

    }
    public void initData(ArrayList<Invoice> invoices){
        this.invoices = invoices;
    }

//    @FXML
//    private void loadBtnClicked(ActionEvent actionEvent) {
//        Invoice invoice = this.invoices.get(0);
//        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
//        this.statusTextField.setText(Integer.toString(invoice.getStatus()));
//        this.invoiceDateTextField.setText((invoice.getInvoiceDate()).toString());
//        this.dueDateTextField.setText((invoice.getDueDate()).toString());
//    }
//
//    @FXML
//    private void loadBtn2Clicked(ActionEvent actionEvent) {
//        Invoice invoice = this.invoices.get(1);
//        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
//        this.statusTextField.setText(Integer.toString(invoice.getStatus()));
//        this.invoiceDateTextField.setText((invoice.getInvoiceDate()).toString());
//        this.dueDateTextField.setText((invoice.getDueDate()).toString());
//    }

    private  void displayInvoice(Invoice invoice){
        this.invoiceIdTextField.setText(Integer.toString(invoice.getInvoiceId()));
        this.statusTextField.setText(Integer.toString(invoice.getStatus()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.dueDateTextField.setText((invoice.getDueDate()).format(formatter));
        this.invoiceDateTextField.setText(invoice.getInvoiceDate().format(formatter));

    }




    @FXML
    protected void initialize(){
//        Invoice invoice = this.invoices.get(0);

//        for (int i = 0; i <= invoices.size(); i++){
//            invoicesComboBox.getItems().add(invoice.toShortString());
//        }
        for( Invoice invoice : this.invoices){
            invoicesComboBox.getItems().add(invoice.toShortString());
        }
//        invoice = this.invoices.get(1);
//        invoicesComboBox.getItems().add(invoice.toShortString());
//        invoice = this.invoices.get(2);
//        invoicesComboBox.getItems().add(invoice.toShortString());
        invoicesComboBox.getSelectionModel().selectFirst();


        Invoice invoice = this.invoices.get(0);
        this.displayInvoice(invoice);
        this.displayLineItems(invoice);
    }


    @FXML
    private void invoiceComboBoxItemSelected(ActionEvent actionEvent) {
        int index = invoicesComboBox.getSelectionModel().getSelectedIndex();
        Invoice invoice = this.invoices.get(index);
        this.displayInvoice(invoice);
        this.displayLineItems(invoice);
    }

    public void getLineItems(){

    }

    @FXML
    private void lineItemsListViewClicked(MouseEvent mouseEvent) {
        this.lineItemsListView.getItems().clear();
        int index = this.invoicesComboBox.getSelectionModel().getSelectedIndex();
        this.invoices.get(index);
        ArrayList<LineItem> lineItems = invoices.get(index).getLineItems();
        int index2 = this.lineItemsListView.getSelectionModel().getSelectedIndex();
        LineItem lineItem = lineItems.get(index2);
        displayLineItem(lineItem);

    }

    private void displayLineItems(Invoice invoice){
        this.lineItemsListView.getItems().clear();
        ArrayList<LineItem> lineItems = invoice.getLineItems();
//        for( Invoice invoice1 : this.invoices){
//            lineItemsListView.getItems().add(lineItems);
//        }
        for (LineItem lineItem : lineItems) {
            lineItemsListView.getItems().add(lineItem.toString());
        }
        descriptionTextField.setText("");
        amountTextField.setText("");
        lineItemsListView.getSelectionModel().selectFirst();

        if (lineItems.size() > 0) {
            displayLineItem(lineItems.get(0));
        }
    }

    private void displayLineItem(LineItem lineItem){
        descriptionTextField.setText(lineItem.getDescription());
        amountTextField.setText( Double.toString(lineItem.getAmount()));
    }

    @FXML
    private void saveInvoiceBtnClicked(ActionEvent actionEvent) {
        int index = invoicesComboBox.getSelectionModel().getSelectedIndex();
        Invoice invoice = this.invoices.get(index);

//        invoice.setStatus(Integer.parseInt(this.statusTextField.getText()));
//        LocalDateTime invoiceDate = new LocalDateTime( //why?
//                Integer.parseInt(this.invoiceDateTextField.getText().substring(0,4)),
//                Integer.parseInt(this.invoiceDateTextField.getText().substring(5,7)),
//                Integer.parseInt(this.invoiceDateTextField.getText().substring(9,10))
//        );


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        invoice.setInvoiceDate(LocalDateTime.parse(this.invoiceDateTextField.getText()));
        invoicesComboBox.getItems().remove(index);
        invoicesComboBox.getItems().add(invoice.toShortString());
        invoicesComboBox.getSelectionModel().select(index);
    }

    @FXML
    private void saveLineItemBtnClicked(ActionEvent actionEvent) {
        //get index of selected line item
        //remove from invoice

        //create new LineItem
        //add LineItem to invoice

        //remove selected LineItem from ListView
        //add new lineItem to ListView
        //select current lineItem in ListView

        int invoiceIndex = invoicesComboBox.getSelectionModel().getSelectedIndex();
        Invoice invoice = this.invoices.get(invoiceIndex);
        int lineItemIndex = lineItemsListView.getSelectionModel().getSelectedIndex();
        invoice.removeLineItem(lineItemIndex);
        LineItem lineItem = new LineItem(0.0, "");
        invoice.addLineItem(lineItemIndex, lineItem);
        this.lineItemsListView.getItems().remove(lineItemIndex);
        this.lineItemsListView.getItems().add(lineItem);
        this.lineItemsListView.getSelectionModel().select(lineItemIndex);
    }

    @FXML
    private void addLineItemBtnClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void deleteLineItemBtnClicked(ActionEvent actionEvent) {
    }
}
