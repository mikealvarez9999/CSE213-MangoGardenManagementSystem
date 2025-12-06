package com.cse213.cse213mangogardenmanagementsystem.FieldSupervisor.model;

import java.io.Serializable;

public class ResourceInventory implements Serializable {
    private final String name;
    private int level;

    public ResourceInventory(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
