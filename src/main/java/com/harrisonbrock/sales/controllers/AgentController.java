package com.harrisonbrock.sales.controllers;

import com.harrisonbrock.sales.models.Agent;
import com.harrisonbrock.sales.repositories.AgentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/agents", produces = MediaType.APPLICATION_JSON_VALUE)
public class AgentController {

    private AgentRepository repository;

    public AgentController(AgentRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public List<Agent> getAllAgents(){
        return  repository.findAll();
    }

}
