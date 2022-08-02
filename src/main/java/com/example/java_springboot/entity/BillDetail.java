package com.example.java_springboot.entity;


import com.example.java_springboot.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill_details")
public class BillDetail extends BaseEntity {
    private int quantity;
    private BigDecimal price;
    private int id_bill;
    private int id_product;

    @ManyToOne
    @JoinColumn(name = "id_bill", insertable = false, updatable = false)
    @JsonIgnore
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;
}
