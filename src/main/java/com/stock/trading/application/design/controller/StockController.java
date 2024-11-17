package com.stock.trading.application.design.controller;


import com.stock.trading.application.design.Entity.StockOrder;
import com.stock.trading.application.design.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/order")
    public StockOrder placeOrder(@RequestBody StockOrder stockOrder) {
        return stockService.createStockOrder(stockOrder);
    }

    @GetMapping("/pending")
    public List<StockOrder> getPendingOrders() {
        return stockService.getPendingOrders();
    }

    @GetMapping("/active")
    public List<StockOrder> getActiveOrders() {
        return stockService.getActiveOrders();
    }
}

