package com.example.java_springboot.entity;

import com.example.java_springboot.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {
    private String name;
    private String gender;
    private String email;
    private String address;
    private int phone_number;
}
