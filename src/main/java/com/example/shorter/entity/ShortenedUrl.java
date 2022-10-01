package com.example.shorter.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="shortened_urls")
@Data
public class ShortenedUrl {
    @Id
    private String id;

    @Column(name = "original_url")
    private String originalUrl;

    @Column(name = "title")
    private String title;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
