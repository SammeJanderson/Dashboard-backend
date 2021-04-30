package com.sammjanderson.PerkProgramApi.repository;


import com.sammjanderson.PerkProgramApi.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
