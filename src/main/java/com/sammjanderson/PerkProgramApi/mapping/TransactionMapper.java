package com.sammjanderson.PerkProgramApi.mapping;

import com.sammjanderson.PerkProgramApi.dto.request.trasaction.TransactionDTO;
import com.sammjanderson.PerkProgramApi.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toModel(TransactionDTO transactionDTO);

    TransactionDTO toDTO(Transaction transaction);




}
