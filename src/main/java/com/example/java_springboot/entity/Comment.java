package com.example.java_springboot.entity;

import com.example.java_springboot.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment extends BaseEntity {
    private String content;
    private  long id_account;
    private int id_product;

    @ManyToOne
    @JoinColumn(name = "id_account", insertable = false, updatable = false)
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;


}
