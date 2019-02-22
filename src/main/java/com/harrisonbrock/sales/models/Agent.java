package com.harrisonbrock.sales.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Set;

public class Agent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long agentcode;


    private String agentname;

    private String workingarea;

    private double commission;

    private String phone;

    private String country;

    public Agent() {
    }
}
