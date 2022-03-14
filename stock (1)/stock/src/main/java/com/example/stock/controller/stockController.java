package com.example.stock.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.stock.DTO.StockDTO;
import com.example.stock.models.Stock;
import com.example.stock.repository.stockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/STOCKS")

@CrossOrigin
public class stockController {

    @Autowired
    private stockRepository stockRepository;

    @GetMapping("/{id}")
    public Optional<Stock> obterStock(@PathVariable(value = "id") Long id) throws Exception {

        return stockRepository.findById(id);
    }

    @GetMapping("/listar")
    public List<Stock> listar() {
        return stockRepository.ListaStock();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Stock adicionar(@RequestBody Stock stocks) {
        return stockRepository.save(stocks);
    }

    // @PutMapping("/{id}") //atualiza pelo ID
    // public stock replaceStock(@RequestBody stock updateStock, @PathVariable Long
    // id){

    // return stockRepository.findById(id)
    // .map(stock -> {
    // stock.setAsk_max(updateStock.getAsk_max() != 0 ? updateStock.getAsk_max() :
    // stock.getAsk_max());
    // stock.setAsk_min(updateStock.getAsk_min() != 0 ? updateStock.getAsk_min() :
    // stock.getAsk_min());
    // stock.setBid_max(updateStock.getBid_max() != 0 ? updateStock.getBid_max() :
    // stock.getBid_max());
    // stock.setBid_min(updateStock.getBid_min() != 0 ? updateStock.getBid_min() :
    // stock.getBid_min());
    // stock.setUpdated_on(Timestamp.valueOf(LocalDateTime.now()));
    // return stockRepository.save(stock);

    // }).orElseGet(() -> {
    // updateStock.setId(id);
    // return stockRepository.save(updateStock);
    // });
    @PostMapping("/ask")
    public ResponseEntity<?> atualiza(@RequestBody StockDTO dto) {
        Stock stock = stockRepository.findById(dto.getId()).orElseThrow();// SELECONA O ID DO STOCK
        if(dto.getAsk_min() != null){
        stock.setAsk_max(dto.getAsk_max());
        stock.setAsk_min(dto.getAsk_min());}
            if(dto.getBid_min()!= null){
        stock.setBid_max(dto.getBid_max());
        stock.setBid_min(dto.getBid_min());}

        Stock save = stockRepository.save(stock);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

}
