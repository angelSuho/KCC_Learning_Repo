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

    @CreationTimestamp
    private Timestamp createDate;
}
