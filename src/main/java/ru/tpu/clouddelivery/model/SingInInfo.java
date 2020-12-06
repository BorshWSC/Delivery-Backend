package ru.tpu.clouddelivery.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class SingInInfo implements Serializable {
    private String email;
    private String password;
}
