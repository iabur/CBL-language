package com.brainstation23.cblmt.language.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by Iabur on July 07, 2021.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Internationalization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String key;
    private String value;

    @ManyToOne
    @JoinColumn(name = "shortCode", nullable = false)
    private Language language;
}
