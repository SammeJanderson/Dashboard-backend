package com.sammjanderson.PerkProgramApi.repository;

import com.sammjanderson.PerkProgramApi.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {
}
