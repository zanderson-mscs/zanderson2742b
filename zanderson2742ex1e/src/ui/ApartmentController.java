package ui;

import domain.Apartment;
import domain.DbContext;
import domain.Invoice;
import domain.Person;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ApartmentController {
  //  private ArrayList<Apartment> apartments = new ArrayList<Apartment>();
 //   private ArrayList<Person> people = new ArrayList<Person>();

    public ApartmentController() {
//        this.apartments = DbContext.getApartments();
//        this.people = DbContext.getPeople();
    }

    @FXML
    protected void initialize(){
        ArrayList<Apartment> apartments = DbContext.getApartments();

//        Invoice invoice = this.invoices.get(0);

//        for (int i = 0; i <= invoices.size(); i++){
//            invoicesComboBox.getItems().add(invoice.toShortString());
//        }
        for( Apartment apartment : apartments){
            aptComboBox.getItems().add(apartment);
        }
        this.aptComboBox.getSelectionModel().selectFirst();
//        invoice = this.invoices.get(1);
//        invoicesComboBox.getItems().add(invoice.toShortString());
//        invoice = this.invoices.get(2);
//        invoicesComboBox.getItems().add(invoice.toShortString());



//        Apartment apt = this.apartments.get(0);

//        this.displayLineItems(apartment);

        for( Person person : this.people){
            tenantComboBox.getItems().add(person);
        }

        for( Person person : this.people){
            adminComboBox.getItems().add(person);
        }

        this.displayApartments(this.aptComboBox.getSelectionModel().getSelectedItem());
    }

    ArrayList<Person> people = new ArrayList<Person>();
    ArrayList<Apartment> apartments = new ArrayList<Apartment>();

    private void displayApartments(Apartment apartment) {
        this.aptNumTextField.setText((apartment.getApartmentNum()));
        this.squareFeetTextField.setText(Integer.toString(apartment.getSquareFeet()));
        this.bathroomsTextField.setText(Integer.toString(apartment.getBathrooms()));
        this.priceTextField.setText(Double.toString(apartment.getPrice()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        this.updatedTextField.setText(apartment.getUpdated().format(formatter));

        //this.aptComboBox.

        int selectedIndex = -1;
        for (int i = 0; i< this.adminComboBox.getItems().size(); i++){
          //  Person person = this.people.get(i);
            Person person = adminComboBox.getItems().get(i);
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
        for (int i = 0; i< this.adminComboBox.getItems().size(); i++){
            Person person = adminComboBox.getItems().get(i);
            if (person.equals(apartment.getTenant())){
                selectedIndex = i;
                break;
            }
        }
    }


    @FXML
    private ComboBox<Apartment> aptComboBox;
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
    private ComboBox<Person> adminComboBox;
    @FXML
    private ComboBox<Person> tenantComboBox;
    @FXML
    private Button saveAptBtn;
    @FXML
    private Button viewInvoiceDlgBtn;

    @FXML
    private void saveAptBtn_Clicked(ActionEvent actionEvent) {
        Apartment apartment = this.aptComboBox.getSelectionModel().getSelectedItem();


        apartment.setApartmentNum(aptNumTextField.getText());
        apartment.setSquareFeet(Integer.parseInt(squareFeetTextField.getText()));
        apartment.setBathrooms(Integer.parseInt(bathroomsTextField.getText()));
        apartment.setPrice(Double.parseDouble(priceTextField.getText()));
        apartment.setUpdated(LocalDateTime.now());

//        int selectedAdminIndex = this.adminComboBox.getSelectionModel().getSelectedIndex();
        apartment.setAdministrator(adminComboBox.getSelectionModel().getSelectedItem());

//        int selectedTenantIndex = this.tenantComboBox.getSelectionModel().getSelectedIndex();
        apartment.setTenant(tenantComboBox.getSelectionModel().getSelectedItem());

        int selectedAptIndex = this.aptComboBox.getSelectionModel().getSelectedIndex();
        this.aptComboBox.getItems().remove( selectedAptIndex);
        this.aptComboBox.getItems().add( selectedAptIndex, apartment);
        this.aptComboBox.getSelectionModel().select( selectedAptIndex);
    }

    @FXML
    private void viewInvoiceDlgBtn_Clicked(ActionEvent actionEvent) {
//        int selectedIndex = aptComboBox.getSelectionModel().getSelectedIndex();
//
//
//        if (selectedIndex >= 0) {

        Apartment apartment = aptComboBox.getSelectionModel().getSelectedItem();
        if(apartment != null) {

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
                stage.setScene(new Scene(pane, 380, 400));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



        private void aptComboBox_ItemSelected (ActionEvent actionEvent) {
            Apartment apartment = aptComboBox.getSelectionModel().getSelectedItem();
            if(apartment != null) {

//                ArrayList<Invoice> invoices = apartment.getInvoices();
                this.displayApartments(apartment);
            }
        }
}





