package com.unibank.entity;

import com.unibank.entity.enums.Currencies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Account {
    @Id
    @Column(name = "account")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "currency_code")
    private Currencies currency;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debit_account_id")
    private Set<Transaction> debitTransaction;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credit_account_id")
    private Set<Transaction> creditTransaction;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && currency == account.currency && Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currency, user);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", accountNumber" + accountNumber +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", user=" + user +
                ", debitTransaction" + debitTransaction +
                ", creditTransaction" + creditTransaction +
                ", createdAt" + createdAt +
                '}';
    }
}