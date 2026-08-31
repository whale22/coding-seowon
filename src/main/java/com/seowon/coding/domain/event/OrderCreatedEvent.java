package com.seowon.coding.domain.event;

import com.seowon.coding.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 필요한 정보를 포함하도록 구성합니다.
 */
@Getter
@RequiredArgsConstructor
public class OrderCreatedEvent {
    List<Long> productIds;
    List<Integer> quantities;

    public OrderCreatedEvent(List<Long> productIds, List<Integer> quantities) {
        this.productIds = productIds;
        this.quantities = quantities;
    }
}
