package com.study.design_patterns.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private String zipCode;
    private String street;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String ibgeCode;
    private String giaCode;
    private String areaCode;
    private String siafiCode;
}
