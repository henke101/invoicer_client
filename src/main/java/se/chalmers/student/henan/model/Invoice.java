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
    private String accountType;
    private String accountNumber;
    
    public Invoice(String dueDate, String invoiceDate, Long id, boolean paid,
            String clientName, double totalRate, String title, String accountType, String accountNumber){
        this.dueDate = dueDate;
        this.invoiceDate = invoiceDate;
        this.id = id;
        this.paid = paid;
        this.clientName = clientName;
        this.totalRate = totalRate;
        this.title = title;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }
     public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getDueDate() {
        return dueDate;
    }
    
    public String getTitle() {
        return title;
    }

    
    public String getInvoiceDate() {
        return invoiceDate;
    }
   
    
    public boolean isPaid() {
        return paid;
    }
   
    
    public String getClientName() {
        return clientName;
    }

    
    public double getTotalRate() {
        return totalRate;
    }
    
    public Long getId() {
        return id;
    }  
    
}

