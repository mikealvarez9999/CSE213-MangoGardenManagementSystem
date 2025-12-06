package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;
import java.util.Random;

public class Suggestion implements Serializable {
    private final int id;
    private String title;
    private String suggestion;

    public Suggestion(String t, String s) {
        this.id = new Random().nextInt(9000) + 1000;
        this.title = t;
        this.suggestion = s;
    }
}
