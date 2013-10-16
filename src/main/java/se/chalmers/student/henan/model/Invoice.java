/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se.chalmers.student.henan.model;


/**
 *
 * @author HenrikAndersson
 */
public class Invoice {
    private String dueDate;
    private String invoiceDate;
    private boolean paid;
    private String clientName;
    private Long id;
    private double totalRate;
    private String title;
    
    public Invoice(String dueDate, String invoiceDate, Long id, boolean paid,
            String clientName, double totalRate, String title){
        this.dueDate = dueDate;
        this.invoiceDate = invoiceDate;
        this.id = id;
        this.paid = paid;
        this.clientName = clientName;
        this.totalRate = totalRate;
        this.title = title;
    }
    public String getDueDate() {
        return dueDate;
    }
    
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getInvoiceDate() {
        return invoiceDate;
    }
    
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public boolean isPaid() {
        return paid;
    }
    
    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
    public double getTotalRate() {
        return totalRate;
    }
    
    public void setTotalRate(int totalRate) {
        this.totalRate = totalRate;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
}

