package com.nibm.project4.service;

import com.nibm.project4.model.Stock;
import com.nibm.project4.repository.Stockrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private Stockrepo stockRepository;

    public void addStock(Stock stock) {
        stockRepository.save(stock);
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

   public void updateStock(int id, Stock updatedStock) {
        Stock existingStock = stockRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock not found"));
        existingStock.setQuantity(updatedStock.getQuantity());
        existingStock.setPrice(updatedStock.getPrice());
        stockRepository.save(existingStock);
    }

    public void deleteStock(int id) {
        stockRepository.deleteById(id);
    }

}
