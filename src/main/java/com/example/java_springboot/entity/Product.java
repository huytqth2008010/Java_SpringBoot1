package com.example.java_springboot.entity;

import com.example.java_springboot.base.BaseEntity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    private String name;
    private String image;
    private String description;
    private BigDecimal unit_price;
    private BigDecimal promotion_price;
    private int qty;
    private int id_category;

    @ManyToOne
    @JoinColumn(name = "id_category", insertable = false, updatable = false)
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;
}
