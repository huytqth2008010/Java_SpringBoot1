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
@Table(name = "bills")
public class Bill extends BaseEntity {
    private BigDecimal total;
    private BigDecimal paid;
    private BigDecimal unpaid;
}
