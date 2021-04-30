package com.sammjanderson.PerkProgramApi.mapping;

import com.sammjanderson.PerkProgramApi.dto.request.order.TransactionDTO;
import com.sammjanderson.PerkProgramApi.dto.response.orders.TransactionStatusDTO;
import com.sammjanderson.PerkProgramApi.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction toModel(TransactionDTO transactionDTO);
    Transaction toMode2(TransactionStatusDTO transactionStatusDTO);

    TransactionDTO toDTO(Transaction transaction);
    TransactionStatusDTO toDTO2(Transaction transaction);






}
