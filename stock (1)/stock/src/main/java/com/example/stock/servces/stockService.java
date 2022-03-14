package com.example.stock.servces;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stock.models.*;
import com.example.stock.repository.*;

@Service
public class stockService {
	@Autowired
	stockRepository repository;

	// GET

	public List<Stock> findAll() {
		return repository.findAll();
	}

	// GET by ID
	public Stock findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	// PUT ID
	public Stock updateById(Long id, Stock stocks) {
		Stock updateStocks = findById(id);
		if (updateStocks == null) {
			return null;
		} else {
			updateStocks.setAsk_min(stocks.getAsk_min());
			updateStocks.setAsk_max(stocks.getAsk_max());
			updateStocks.setBid_min(stocks.getBid_min());
			updateStocks.setBid_max(stocks.getBid_max());
			updateStocks.setUpdated_on(Timestamp.from(Instant.now()));
			return repository.save(stocks);
		}
	}

//	POST
	public Stock save(Stock stocks) {
		return repository.save(stocks);
	}

}
