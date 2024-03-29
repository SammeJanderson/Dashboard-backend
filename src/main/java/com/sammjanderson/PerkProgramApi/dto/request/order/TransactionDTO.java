package com.sammjanderson.PerkProgramApi.dto.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private UUID clientId;

    private String productName;

    private UUID productId;

    private Integer productCost;

    private Integer previousBalance;

    private Integer newBalance;

}
