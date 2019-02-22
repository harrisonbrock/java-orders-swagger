package com.harrisonbrock.sales.controllers;

import com.harrisonbrock.sales.models.Agent;
import com.harrisonbrock.sales.repositories.AgentRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
    public List<Agent> getAllAgents() {
        return repository.findAll();
    }

    @GetMapping("/agentcode/{id}")
    public List<Agent> getAgentById(@PathVariable long id) {
        Optional<Agent> agents = repository.findById(id);

        if (agents.isPresent()) {
            return agents.stream().collect(Collectors.toList());
        } else {
            return agents.stream().collect(Collectors.toList());
        }
    }

    @PostMapping()
    public Agent insertOneAgent(@RequestBody Agent newAgent) {
        return repository.save(newAgent);
    }

    @PutMapping("/agentcode/{id}")
    public Agent updateAgent(@RequestBody Agent newAgent, @PathVariable long id) {
        Optional<Agent> updatingAgent = repository.findById(id);

        if (updatingAgent.isPresent()) {
            newAgent.setAgentcode(id);
            repository.save(newAgent);
            return newAgent;
        }
        else {
            return null;
        }
    }

}
