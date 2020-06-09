package co.com.magudel.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Traceability")
public class Traceability implements Serializable {
    private static final long serialVersionUID = 6775857771434582361L;

    @Id
    @SequenceGenerator(name = "traceability_id_seq", sequenceName = "traceability_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "traceability_id_seq")
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name = "identification", nullable = false)
    private String identification;

    @Column(name = "transaction_date", nullable = false)
    private Date transactionDate;


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
