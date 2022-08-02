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
@Table(name = "replys")
public class Reply extends BaseEntity {
    private String content;
    private int id_comment;
    private int id_product;
    private long id_account;

    @ManyToOne
    @JoinColumn(name = "id_comment", insertable = false, updatable = false)
    @JsonIgnore
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "id_account", insertable = false, updatable = false)
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;
}
