package ui;

import domain.Apartment;
import domain.DbContext;
import domain.Invoice;
import domain.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ApartmentController {
    private ArrayList<Apartment> apartments = new ArrayList<Apartment>();
    private ArrayList<Person> people = new ArrayList<Person>();

    public ApartmentController() {
        this.apartments = DbContext.getApartments();
        this.people = DbContext.getPeople();
    }

    @FXML
    protected void initialize(){
//        Invoice invoice = this.invoices.get(0);

//        for (int i = 0; i <= invoices.size(); i++){
//            invoicesComboBox.getItems().add(invoice.toShortString());
//        }
        for( Apartment apartment : this.apartments){
            aptComboBox.getItems().add(apartment.toShortString());
        }
//        invoice = this.invoices.get(1);
//        invoicesComboBox.getItems().add(invoice.toShortString());
//        invoice = this.invoices.get(2);
//        invoicesComboBox.getItems().add(invoice.toShortString());
        aptComboBox.getSelectionModel().selectFirst();


        Apartment apt = this.apartments.get(0);

//        this.displayLineItems(apartment);

        for( Person person : this.people){
            tenantComboBox.getItems().add(person.toShortString());
        }

        for( Person person : this.people){
            adminComboBox.getItems().add(person.toShortString());
        }

        this.displayApartments(apt);
    }

    private void displayApartments(Apartment apartment) {
        this.aptNumTextField.setText((apartment.getApartmentNum()));
        this.squareFeetTextField.setText(Integer.toString(apartment.getSquareFeet()));
        this.bathroomsTextField.setText(Integer.toString(apartment.getBathrooms()));
        this.priceTextField.setText(Double.toString(apartment.getPrice()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.updatedTextField.setText(apartment.getUpdated().format(formatter));

        //this.aptComboBox.

        int selectedIndex = -1;
        for (int i = 0; i< this.people.size(); i++){
            Person person = this.people.get(i);
            if (person.equals(apartment.getAdministrator())){
                selectedIndex = i;
                break;
            }
        }
        this.adminComboBox.getSelectionModel().getSelectedIndex();
        selectedIndex = -1;
        for (int i = 0; i< this.people.size(); i++){
            Person person = this.people.get(i);
            if (person.equals(apartment.getTenant())){
                selectedIndex = i;
                break;
            }
        }

        this.tenantComboBox.getSelectionModel().getSelectedIndex();
        selectedIndex = -1;
        for (int i = 0; i< this.people.size(); i++){
            Person person = this.people.get(i);
            if (person.equals(apartment.getTenant())){
                selectedIndex = i;
                break;
            }
        }
    }


    @FXML
    private ComboBox aptComboBox;
    @FXML
    private TextField aptNumTextField;
    @FXML
    private TextField squareFeetTextField;
    @FXML
    private TextField bathroomsTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TextField updatedTextField;
    @FXML
    private ComboBox adminComboBox;
    @FXML
    private ComboBox tenantComboBox;
    @FXML
    private Button saveAptBtn;
    @FXML
    private Button viewInvoiceDlgBtn;

    @FXML
    private void saveAptBtn_Clicked(ActionEvent actionEvent) {
        int aptIndex = this.aptComboBox.getSelectionModel().getSelectedIndex();
        Apartment apartment = this.apartments.get(aptIndex);

//        apartment.setApartmentId(int apartmentId) {
//            String errMsg = "";
//            if (apartmentId >= 100 && apartmentId <= 199)
//                this.apartmentId = apartmentId;
//            else
//                errMsg = Integer.toString(apartmentId) + " is invalid. ApartmentId must be >= 101 and <= 199";
//            return errMsg;
//        }
//
//        apartment.setApartmentNum(String apartmentNum) {
//            String errMsg = "";
//            if (apartmentNum != null && apartmentNum.length() >= 1 && apartmentNum.length() <= 4)
//                this.apartmentNum = apartmentNum;
//            else
//                errMsg = "ApartmentNum is required";
//            return errMsg;
//        }
//
//        apartment.setSquareFeet(int squareFeet) {
//            String errMsg = "";
//            if (squareFeet >= 200 && squareFeet <= 2000)
//                this.squareFeet = squareFeet;
//            else
//                errMsg = Integer.toString(squareFeet) + " is invalid. Square feet must be > 200 and < 2000.";
//            return errMsg;
//        }
//
//        apartment.setBathrooms(int bathrooms) {
//            String errMsg = "";
//            if (bathrooms >= 1 && bathrooms <= 3)
//                this.bathrooms = bathrooms;
//            else
//                errMsg = Integer.toString(bathrooms) + " is invalid. Bathrooms must be > 0 and < 4.";
//            return errMsg;
//        }
//
//        apartment.setPrice(double price) {
//            String errMsg = "";
//            if (price > 99.99 && price < 9999.99)
//                this.price = price;
//            else
//                errMsg = Double.toString(price) + " is invalid. Price must be > 99.99 and < 9999.99";
//            return errMsg;
//        }

        this.aptComboBox.getItems().remove(aptIndex);
        this.aptComboBox.getItems().add(aptIndex, apartment.toShortString());
        this.aptComboBox.getSelectionModel().select(aptIndex);
    }

    @FXML
    private void viewInvoiceDlgBtn_Clicked(ActionEvent actionEvent) {
        int selectedIndex = aptComboBox.getSelectionModel().getSelectedIndex();


        if( selectedIndex >= 0){
            Apartment apartment = apartments.get(selectedIndex);
            ArrayList<Invoice> invoices = apartment.getInvoices();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InvoiceView.fxml"));
            InvoiceController invoiceController = new InvoiceController();
            invoiceController.initData(invoices);
            fxmlLoader.setController(invoiceController);

            Pane pane = (Pane) fxmlLoader.load();
            Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Invoice");
            stage.setScene(new Scene(pane,380, 400 ));
            stage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


    private void aptComboBox_ItemSelected(ActionEvent actionEvent) {
        selectedIndex = aptComboBox.getSelectionModel().getSelectedIndex();
        if( selectedIndex >= 0){
            displayApartments(apartments.get(selectedIndex));
        }
    }



}
