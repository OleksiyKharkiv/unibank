package com.unibank.entity;

import com.unibank.entity.enums.Currencies;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "account_number", nullable = false, unique = true)
    private String accountNumber;
    @Column(name = "balance", nullable = false)
    private BigDecimal balance;
    @Column(name = "currency_code", nullable = false)
    private Currencies currency;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "from_account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> fromAccounts= new HashSet<>();

    @OneToMany(mappedBy = "to_account",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Transaction> toAccounts = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && currency == account.currency && Objects.equals(user, account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountNumber" + accountNumber +
                ", balance=" + balance +
                ", currency='" + currency + '\'' +
                ", user=" + user +
                ", createdAt" + createdAt +
                '}';
    }
}