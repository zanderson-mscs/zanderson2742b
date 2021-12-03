package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Invoice {
    private int invoiceId;
    private int status;
    private LocalDateTime invoiceDate;
    private LocalDateTime dueDate;
//    private ArrayList<LineItem> lineItems;
    private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();
    private Apartment apartment = null;

    /**
     *
     * @param status
     * @param invoiceDate
     * @param dueDate
     */
    public Invoice(int status, LocalDateTime invoiceDate, LocalDateTime dueDate, Apartment apartment) {
        this.status = status;
        this.invoiceDate = invoiceDate;
        this.dueDate = dueDate;
        this.apartment = apartment;

    }

    /**
     *
     * @param invoice
     */
    public Invoice(Invoice invoice) {
        this.status = invoice.status;
        this.invoiceDate = invoice.invoiceDate;
        this.dueDate = invoice.dueDate;
        this.apartment = invoice.apartment;
    }

    public Invoice copy() {
//     Invoice invoice = new Invoice(this.status, this.invoiceDate, this.dueDate);
//     invoice.invoiceId = this.invoiceId;
//     return invoice;
        return new Invoice(this);
    }

    /**
     *
     * @param lineItem
     */
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(new LineItem(lineItem));
    }

    public void addLineItem(int index, LineItem lineItem) {
        this.lineItems.add(index, new LineItem(lineItem));
    }


    public LineItem removeLineItem(int index) {
        LineItem lineItem = null;
        if (index >= 0 && index < this.lineItems.size()) {
            lineItem = this.lineItems.get(index).copy();
            this.lineItems.remove(index);
        }
        return lineItem;

    }

    public LineItem removeLineItem(LineItem lineItem) {
        LineItem removedLineItem = null;
        int index = this.lineItems.indexOf(lineItem);
        removedLineItem = this.lineItems.get(index).copy();
        this.lineItems.remove(removedLineItem);
        return removedLineItem;
    }

    public double total() {
        double total = 0.0;
        for (int i = 0; i < lineItems.size(); i++) {
            double amount = lineItems.get(i).getAmount();
            total += amount;
        }
        return total;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getInvoiceDate() {
        return invoiceDate;
    }

    public LocalDateTime getDueDate() { return dueDate; }

    public ArrayList<LineItem> getLineItems() {return lineItems;}

    public LineItem getLineItem(int index) {
        LineItem item = new LineItem(getLineItem(index));
        for (LineItem lineItem : this.lineItems){
            lineItem.copy();
        }
        return item;
    } //what?

    public Invoice getInvoice(Invoice invoice) {return invoice;}

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate.format(formatter) +
                ", dueDate=" + dueDate.format(formatter) +
                '}';
    }

    public String toShortString() {
        return Integer.toString(invoiceId) +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setInvoiceDate(LocalDateTime invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    private void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getStatus() == invoice.getStatus() &&
                this.invoiceDate.equals(invoice.invoiceDate) &&
                Objects.equals(getDueDate(), invoice.getDueDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getStatus(), getInvoiceDate(), getDueDate());
    }

    private void setStatus() {
    }

    private Apartment getApartment() {
        return this.apartment;
    }

//    public Invoice copy() {
//        return new Invoice(this);
//    }

}
