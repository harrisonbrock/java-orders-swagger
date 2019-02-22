package com.harrisonbrock.sales.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "agents")
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

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "agent")
    private Set<Customer> customers;

    public Agent() {
    }
}
