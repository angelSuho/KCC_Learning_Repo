package com.kcc.security1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.*;

@Entity
@Data
@Table(name = "user2")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String role; // ROLE_USER, ROLE_ADMIN

    private String provider;
    private String providerId;

    @CreationTimestamp
    private Timestamp createDate;

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }

    public User(String username, String email, String role, String provider, String providerId) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
    }
}
