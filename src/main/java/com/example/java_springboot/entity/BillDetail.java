package com.example.java_springboot.entity;


import com.example.java_springboot.base.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
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
}
