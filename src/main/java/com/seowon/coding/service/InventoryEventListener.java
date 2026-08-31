package com.seowon.coding.service;

import com.seowon.coding.domain.event.OrderCreatedEvent;
import com.seowon.coding.domain.model.Product;
import com.seowon.coding.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;


@Slf4j
@Component
@RequiredArgsConstructor
public class InventoryEventListener {
    private final ProductRepository productRepository;
    /**
     * 주문 생성 이벤트를 구독하여 재고를 차감하는 로직을 구현하세요.
     * 1. @EventListener 또는 @TransactionalEventListener 활용
     * 2. 주문-재고 시스템 분리 시 발생할 수 있는 '최종적 일관성(Eventual Consistency)' 고려
     * 3. 실패 시 보상 트랜잭션 또는 재시도 전략에 대한 고민을 주석으로 남길 것
     */

    @TransactionalEventListener
    public void handleOrderCreatedEvent(OrderCreatedEvent event) throws Exception {
        Exception RuntimeException = new RuntimeException();
        Product product;
        for(int i=0;i<event.getProductIds().size();i++){
            int stock;
            int buyStock = event.getQuantities().get(i);
            product = productRepository.findById(event.getProductIds().get(i)).get();
            stock = product.getStockQuantity();
            if(stock - buyStock >= 0) stock -= buyStock;
            else throw RuntimeException;
        }
    }
}
