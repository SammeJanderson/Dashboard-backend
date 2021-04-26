package com.sammjanderson.PerkProgramApi.repository;

import com.sammjanderson.PerkProgramApi.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
