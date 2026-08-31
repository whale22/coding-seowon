package com.seowon.coding.dto;

import com.seowon.coding.domain.model.Order;
import com.seowon.coding.domain.model.OrderItem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsContructor
@AllArgsContructor
@Builder
public class OrderDto {
    private Long id;
    private String customerName;
    private String customerEmail;
    @Enumerated(EnumType.STRING)
    private Order.OrderStatus status;

    private LocalDateTime orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<OrderItem> items = new ArrayList<>();

    private BigDecimal totalAmount;
}
