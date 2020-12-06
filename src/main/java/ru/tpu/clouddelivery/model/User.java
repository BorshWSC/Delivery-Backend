package ru.tpu.clouddelivery.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "delivery_user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String email;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String password;

    private String address;
}
