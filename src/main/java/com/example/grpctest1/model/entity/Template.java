package com.example.grpctest1.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "template", schema = "public")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Data
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "FieldHandler"})
public class Template {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "template_code")
    private String templateCode;

    @Basic
    @Column(name = "template_name")
    private String templateName;

    @Basic
    @Column(name = "template_description")
    private String templateDescription;

    @Basic
    @Column(name = "template_content")
    private String templateContent;

    @Basic
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Basic
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
