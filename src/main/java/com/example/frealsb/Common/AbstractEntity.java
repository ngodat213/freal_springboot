package com.example.frealsb.Common;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    protected String id;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @CreatedBy
    @Column(nullable = false, updatable = false, length = 50)
    protected String createdBy;

    @LastModifiedDate
    protected LocalDateTime lastModifiedAt;

    @LastModifiedBy
    @Column(length = 50)
    protected String lastModifiedBy;

    protected boolean isDeleted = false;
}