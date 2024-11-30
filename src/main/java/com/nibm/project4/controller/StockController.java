package com.nibm.project4.controller;

import com.nibm.project4.model.Stock;
import com.nibm.project4.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<String> addStock(@RequestBody Stock stock) {
        stockService.addStock(stock);
        return ResponseEntity.ok("Stock item added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        return ResponseEntity.ok(stockService.getAllStocks());
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<String> updateStock(@PathVariable int id, @RequestBody Stock updatedStock) {
        stockService.updateStock(id, updatedStock);
        return ResponseEntity.ok("Stock updated successfully");
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStock(@PathVariable int id) {
        stockService.deleteStock(id);
        return ResponseEntity.ok("Stock deleted successfully");
    }

    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }
}
