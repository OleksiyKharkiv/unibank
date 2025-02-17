package com.unibank.entity;

import com.unibank.entity.enums.Currencies;
import com.unibank.entity.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "from_account", referencedColumnName = "id")
    private Account fromAccount;
    @ManyToOne
    @JoinColumn(name = "to_account", referencedColumnName = "id")
    private Account toAccount;
    @Column(name = "amount", nullable = false)
    private BigDecimal amount;
    @Column(name = "currency_code", nullable = false)
    private Currencies currency;
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction transaction =  (Transaction) o;
        return Objects.equals(id, transaction.id) && createdAt == transaction.createdAt && Objects.equals(fromAccount, transaction.fromAccount) && Objects.equals(toAccount, transaction.toAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, fromAccount, toAccount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id'" + id + '\'' +
                "fromAccount" + fromAccount +
                "toAccount" + toAccount +
                "currency" + currency +
                "status" + status +
                "createdAt" + createdAt +
                '}';
    }
}