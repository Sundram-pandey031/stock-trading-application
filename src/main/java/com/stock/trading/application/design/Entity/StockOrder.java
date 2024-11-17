package com.stock.trading.application.design.Entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StockOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stockSymbol;
    private double targetPrice;
    private double sellPrice;
    private boolean purchased;
    private boolean sold;
}

