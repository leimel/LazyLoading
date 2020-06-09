package co.com.magudel.model.mudanza.entity;

import java.util.Date;

public class TraceabilityEntity {

    private Long id;
    private String identification;
    private Date transactionDate;

    public TraceabilityEntity(String identification, Date transactionDate) {
        this.id = null;
        this.identification = identification;
        this.transactionDate = transactionDate;
    }

    public TraceabilityEntity(){
        this.id = null;
        this.identification = null;
        this.transactionDate = null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
