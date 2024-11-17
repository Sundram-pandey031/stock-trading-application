package com.stock.trading.application.design.service.impl;

import com.stock.trading.application.design.Entity.StockOrder;
import com.stock.trading.application.design.repository.StockOrderRepository;
import com.stock.trading.application.design.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StockServiceimpl implements StockService {

    private final StockOrderRepository stockOrderRepository;

    public StockOrder createStockOrder(StockOrder stockOrder) {
        return stockOrderRepository.save(stockOrder);
    }

    public List<StockOrder> getPendingOrders() {
        return stockOrderRepository.findByPurchasedFalse();
    }

    public List<StockOrder> getActiveOrders() {
        return stockOrderRepository.findByPurchasedTrueAndSoldFalse();
    }

    public void updateStockOrder(StockOrder stockOrder) {
        stockOrderRepository.save(stockOrder);
    }
}
