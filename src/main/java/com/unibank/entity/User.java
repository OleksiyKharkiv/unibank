package com.unibank.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "email")
    private String email;
    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "user")
    private Set<Account> account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && email.equals(user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                "userName='" + userName + '\'' +
                "email='" + email + '\'' +
                "createdAt+'" + createdAt +
                '}';
    }
}