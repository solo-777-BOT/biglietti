package com.example;

public class Biglietti {
    private int gold;
    private int pit;
    private int parterre;
    
    public Biglietti(int gold, int pit, int parterre) {
        this.gold = gold;
        this.pit = pit;
        this.parterre = parterre;
    }

    public int getGold() {
        return gold;
    }

    public int getPit() {
        return pit;
    }

    public int getParterre() {
        return parterre;
    }
    
}
