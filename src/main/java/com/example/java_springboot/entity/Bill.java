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
@Table(name = "bills")
public class Bill extends BaseEntity {
    private BigDecimal total;
    private BigDecimal paid;
    private BigDecimal unpaid;
    private int payment;
    private int id_customer;
    private long id_account;

    @ManyToOne
    @JoinColumn(name = "id_customer", insertable = false, updatable = false)
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_account", insertable = false, updatable = false)
    @JsonIgnore
    private Account account;
}
