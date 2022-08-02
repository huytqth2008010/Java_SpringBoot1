package com.example.java_springboot.entity;

import com.example.java_springboot.base.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    private int customerId;
    private Double totalPrice;
    private String shipName;
    private String shipAddress;
    private int shipPhone;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetailSet;
}
