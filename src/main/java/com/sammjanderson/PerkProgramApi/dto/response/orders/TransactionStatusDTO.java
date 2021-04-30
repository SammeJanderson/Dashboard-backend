package com.sammjanderson.PerkProgramApi.dto.response.orders;

import com.sammjanderson.PerkProgramApi.enums.OrderStatus;
import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionStatusDTO {

    private UUID transactionId;

    private String productName;

    private UUID productId;

    private UUID clientId;

    private Integer productCost;

    private Integer previousBalance;

    private Integer newBalance;

    private String orderNumber;

    private OrderStatus orderStatus;

    private Date lastUpdated;

}
