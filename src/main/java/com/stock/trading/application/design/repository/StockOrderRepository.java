package com.stock.trading.application.design.repository;




import com.stock.trading.application.design.Entity.StockOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockOrderRepository extends JpaRepository<StockOrder, Long> {
    List<StockOrder> findByPurchasedFalse();
    List<StockOrder> findByPurchasedTrueAndSoldFalse();
}

