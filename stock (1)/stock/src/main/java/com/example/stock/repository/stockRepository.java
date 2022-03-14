package com.example.stock.repository;


import java.util.List;

import com.example.stock.models.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface stockRepository extends JpaRepository<Stock, Long> {
// @Query (value = "select * from stocks where stock_symbol = :stock_symbol", nativeQuery = true)
// stock findBySymbol(@Param ("stock_symbol") String stock_symbol);

@Query(value = "select * from stocks fetch first 25 rows only" , nativeQuery = true)
	List <Stock> ListaStock ();

}