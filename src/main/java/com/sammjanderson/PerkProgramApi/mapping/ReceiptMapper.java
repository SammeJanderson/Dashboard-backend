package com.sammjanderson.PerkProgramApi.mapping;

import com.sammjanderson.PerkProgramApi.dto.request.receipt.ReceiptDTO;
import com.sammjanderson.PerkProgramApi.entity.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReceiptMapper {

    ReceiptMapper INSTANCE = Mappers.getMapper(ReceiptMapper.class);

    Receipt toModel(ReceiptDTO receiptDTO);

    ReceiptDTO toDTO(Receipt receipt);

}
