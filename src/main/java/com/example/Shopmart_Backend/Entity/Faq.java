package com.example.Shopmart_Backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Faq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String faqId;
    private String question;
    private String answer;
    private Boolean status;

}
