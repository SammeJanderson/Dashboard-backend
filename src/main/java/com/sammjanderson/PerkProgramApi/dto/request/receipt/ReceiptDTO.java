package com.sammjanderson.PerkProgramApi.dto.request.receipt;


import com.sammjanderson.PerkProgramApi.entity.Product;
import com.sammjanderson.PerkProgramApi.utils.OrderNumberGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID receiptId;

    private String orderId = OrderNumberGenerator.generateOrderId();

    private List<Product> products;
}
