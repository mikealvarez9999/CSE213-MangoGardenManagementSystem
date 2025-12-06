package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;

public class Worker implements Serializable {
    private final String id;
    private final String name;

    public Worker(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
