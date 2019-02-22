package com.harrisonbrock.sales.controllers;

import com.harrisonbrock.sales.models.Agent;
import com.harrisonbrock.sales.repositories.AgentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/agentcode/{id}")
    public List<Agent> getAgentById(@PathVariable long id) {
        Optional<Agent> agents = repository.findById(id);

        if (agents.isPresent()) {
            return agents.stream().collect(Collectors.toList());
        }
        else {
            return agents.stream().collect(Collectors.toList());
        }

    }

}
