package com.unibank.entity;

import com.unibank.entity.enums.Currencies;
import com.unibank.entity.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Transaction {
    @Id
    @Column(name = "id")
    private UUID id;
    @Column(name = "from_account")
    private String fromAccount;
    @Column(name = "to_account")
    private String toAccount;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "currency_code")
    private Currencies currency;
    @Column(name = "status")
    private Status status;
    @Column(name = "created_at")
    private Timestamp createdAt;

}