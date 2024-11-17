package com.stock.trading.application.design.utility;


import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StockPriceFetcher {

    public double fetchPrice(String stockSymbol) {
        // Simulate stock price with random value (replace with actual API call)
        return 50 + new Random().nextDouble() * 50;
    }
}

