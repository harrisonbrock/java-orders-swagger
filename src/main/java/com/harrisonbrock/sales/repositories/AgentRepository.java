package com.harrisonbrock.sales.repositories;

import com.harrisonbrock.sales.models.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long> {
}
