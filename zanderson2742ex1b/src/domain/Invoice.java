package domain;

import javax.sound.sampled.Line;
import java.util.ArrayList;

public class Invoice {
    private int invoiceId;
    private int status;
    private GDate invoiceDate;
    private GDate dueDate;
    private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();

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
        this.invoiceDate = new GDate(invoice.invoiceDate);
        this.dueDate = new GDate(invoice.dueDate );
    }

    public Invoice copy() {
     Invoice invoice = new Invoice(this.status, this.invoiceDate, this.dueDate);
     invoice.invoiceId = this.invoiceId;
     return invoice;
    }

    /**
     *
     * @param lineItem
     */
    public void addLineItem(LineItem lineItem) {
        this.lineItems.add(new LineItem(lineItem));
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
        return invoiceDate;
    }

    public GDate getDueDate() {
        return dueDate;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId=" + invoiceId +
                ", status=" + status +
                ", invoiceDate=" + invoiceDate +
                ", dueDate=" + dueDate +
                '}';
    }
}
