package com.harrisonbrock.sales.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "agent")
    @JsonIgnore
    private Set<Customer> customers = new HashSet<>();

    public Agent() {
    }
}
