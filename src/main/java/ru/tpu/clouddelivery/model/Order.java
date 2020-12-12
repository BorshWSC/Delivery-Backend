package ru.tpu.clouddelivery.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "delivery_order")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Column(updatable = false)
    private Date orderDate;

    private Integer total;

    @OneToMany(mappedBy = "order")
    private Set<OrderedDish> dishes;
}
