package com.stock.trading.application.design.scheduler;



import com.stock.trading.application.design.Entity.StockOrder;
import com.stock.trading.application.design.service.StockService;
import com.stock.trading.application.design.utility.StockPriceFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StockPriceScheduler {

    private final StockService stockService;
    private final StockPriceFetcher stockPriceFetcher;

    @Scheduled(fixedRate = 10000) // Runs every 10 seconds
    public void checkAndBuyStocks() {
        List<StockOrder> pendingOrders = stockService.getPendingOrders();
        for (StockOrder order : pendingOrders) {
            double currentPrice = stockPriceFetcher.fetchPrice(order.getStockSymbol());
            if (currentPrice <= order.getTargetPrice()) {
                order.setPurchased(true);
                stockService.updateStockOrder(order);
                System.out.println("Purchased stock: " + order.getStockSymbol());
            }
        }
    }

    @Scheduled(fixedRate = 10000) // Runs every 10 seconds
    public void checkAndSellStocks() {
        List<StockOrder> activeOrders = stockService.getActiveOrders();
        for (StockOrder order : activeOrders) {
            double currentPrice = stockPriceFetcher.fetchPrice(order.getStockSymbol());
            if (currentPrice >= order.getSellPrice()) {
                order.setSold(true);
                stockService.updateStockOrder(order);
                System.out.println("Sold stock: " + order.getStockSymbol());
            }
        }
    }
}

