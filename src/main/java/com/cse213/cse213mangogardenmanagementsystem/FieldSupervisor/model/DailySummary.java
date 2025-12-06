package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class DailySummary implements Serializable {
    private final int id;
    private LocalDate date;
    private String content;
    public DailySummary(LocalDate d, String c) {
        this.id = new Random().nextInt(9000) + 1000;
        this.date = d; this.content = c;
    }
}

