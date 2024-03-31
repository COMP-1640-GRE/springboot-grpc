package com.example.grpctest1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user", schema = "public")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "username")
    private String username;

    @Basic
    @Column(name = "password")
    private String password;

    @Basic
    @Column(name = "secret")
    private String secret;

    @Basic
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public enum RoleType {
        administrator, student, guest
    }

    @Basic
    @Column(name = "email")
    private String email;

    @Basic
    @Column(name = "first_name")
    private String firstName;

    @Basic
    @Column(name = "last_name")
    private String lastName;

    @Basic
    @Column(name = "account_status")
    @Enumerated(EnumType.STRING)
    private AccountType accountStatus;

    public enum AccountType {
        active, locked, inactive
    }

    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;
}
