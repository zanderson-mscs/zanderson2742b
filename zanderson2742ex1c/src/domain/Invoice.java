package domain;

import java.util.ArrayList;

public class Invoice {
    private int invoiceId;
    private int status;
    private GDate invoiceDate;
    private GDate dueDate;
    private ArrayList<LineItem> lineItems;

    /**
     *
     * @param status
     * @param invoiceDate
     * @param dueDate
     */
    public Invoice(int status, GDate invoiceDate, GDate dueDate) {
        this.status = status;
        this.invoiceDate = new GDate(invoiceDate);
        this.dueDate = new GDate(dueDate);
    }

    /**
     *
     * @param invoice
     */
    public Invoice(Invoice invoice) {
        this.status = invoice.status;
        this.invoiceDate = invoice.invoiceDate;
        this.dueDate = invoice.dueDate;
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

    public GDate getInvoiceDate() {
        return invoiceDate.copy();
    }

    public GDate getDueDate() { return dueDate.copy(); }

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
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                '}';
    }

    public String toShortString() {
        return Integer.toString(invoiceId) +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate;
    }

    private void setStatus(int status) {
        this.status = status;
    }

    private void setInvoiceDate(GDate invoiceDate) {
        this.invoiceDate = invoiceDate.copy();
    }

    private void setDueDate(GDate dueDate) {
        this.dueDate = dueDate.copy();
    }
}
