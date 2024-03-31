package com.example.grpctest1.repository;

import com.example.grpctest1.model.entity.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@EnableJpaRepositories
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    @Query("select n from Notification n " +
            "where n.user.id = :userId " +
            "and n.seen = :seen" +
            " order by n.createdAt desc")
    Page<Notification> getNotifications(@Param("userId") Long userId, @Param("seen") boolean seen, Pageable pageable);
}
