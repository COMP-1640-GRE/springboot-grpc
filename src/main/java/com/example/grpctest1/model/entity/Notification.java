package com.example.grpctest1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notification", schema = "public")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Notification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @Basic
    @Column(name = "with_email")
    private boolean withEmail;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "url")
    private String url;

    @Basic
    @Column(name = "seen")
    private boolean seen;

    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
