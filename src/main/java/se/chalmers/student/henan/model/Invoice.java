package se.chalmers.student.henan.model;


/**
 * Simple model representing an Invoice
 * @author HenrikAndersson
 * */
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
    private String ownerName;
    
    public Invoice(String dueDate, String invoiceDate, Long id, boolean paid,
            String clientName, double totalRate, String title, String accountType, String accountNumber, String ownerName){
        this.dueDate = dueDate;
        this.invoiceDate = invoiceDate;
        this.id = id;
        this.paid = paid;
        this.clientName = clientName;
        this.totalRate = totalRate;
        this.title = title;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.ownerName = ownerName;
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
    public String getOwnerName(){
        return ownerName;
    }
    
}

