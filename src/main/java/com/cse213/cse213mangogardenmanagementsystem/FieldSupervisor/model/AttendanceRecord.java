package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;

public class AttendanceRecord implements Serializable {
    private final int id;
    private LocalDate date;
    private String workerId;
    private String status;
    public AttendanceRecord(LocalDate d, String w, String s) {
        this.id = new Random().nextInt(9000) + 1000;
        this.date = d; this.workerId = w; this.status = s;
    }
}
