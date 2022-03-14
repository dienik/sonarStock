package com.example.stock.DTO;

import java.security.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

public class StockDTO {
    private Long id;
    private String stock_symbol;
    private String stock_name;
    private Double ask_min;
    private Double ask_max;
    private Double bid_min;
    private Double bid_max;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAsk_min() {
        return ask_min;
    }

    public void setAsk_min(Double ask_min) {
        this.ask_min = ask_min;
    }

    public Double getAsk_max() {
        return ask_max;
    }

    public void setAsk_max(Double ask_max) {
        this.ask_max = ask_max;
    }

    public Double getBid_min() {
        return bid_min;
    }

    public void setBid_min(Double bid_min) {
        this.bid_min = bid_min;
    }

    public Double getBid_max() {
        return bid_max;
    }

    public void setBid_max(Double bid_max) {
        this.bid_max = bid_max;
    }

    public StockDTO(Long id, Double ask_min, Double ask_max, Double bid_min,
            Double bid_max) {
        this.id = id;

        this.ask_min = ask_min;
        this.ask_max = ask_max;
        this.bid_min = bid_min;
        this.bid_max = bid_max;

    }

    public StockDTO() {

    }

}
