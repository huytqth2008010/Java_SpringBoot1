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
@Table(name = "slides")
public class Slide extends BaseEntity {
    private String image;
}
