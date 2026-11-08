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
    public synchronized boolean acquista(String tipo,int quantità)throws Exception{
        if(tipo.equalsIgnoreCase("Gold")){
            if(this.gold<quantità){
                return false;
            }else{
                this.gold-=quantità;
                return true;
            }
        }else if(tipo.equalsIgnoreCase("Pit")){
            if(this.pit<quantità){
                return false;
            }else{
                this.pit-=quantità;
                return true;
            }
        }else if(tipo.equalsIgnoreCase("parterre")){
            if(this.parterre<quantità){
                return false;
            }else{
                this.parterre-=quantità;
                return true;
            }
        }else{
            throw new Exception("tipo non valido");
        }
    }
}
