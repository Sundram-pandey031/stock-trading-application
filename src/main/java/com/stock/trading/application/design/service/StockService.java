package com.stock.trading.application.design.service;

import com.stock.trading.application.design.Entity.StockOrder;

import java.util.List;

public interface StockService {

    public StockOrder createStockOrder(StockOrder stockOrder);

    public List<StockOrder> getPendingOrders();
    public List<StockOrder> getActiveOrders();
    public void updateStockOrder(StockOrder stockOrder);
}
