package com.example.grpctest1.repository;

import com.example.grpctest1.model.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
@Repository
@EnableJpaRepositories
public interface TemplateRepository extends JpaRepository<Template, Long> {
    Template findByTemplateCode(String templateCode);
}
