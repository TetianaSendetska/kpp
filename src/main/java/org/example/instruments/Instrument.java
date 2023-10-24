package org.example.instruments;

public class Instrument {
    protected String name;
    protected double prize;
    protected String type;

    public void setName(String name) {
        this.name = name;
    }
    public void setPrize(double prize) {
        this.prize = prize;
    }
    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }
    public double getPrize() {
        return prize;
    }
    public String getType() {
        return type;
    }

    public Instrument(){
        name = "Instrument";
        prize = 00.00;
        type = "General";
    }
    public Instrument(String name, double prize, String type){
        this.name = name;
        this.prize = prize;
        this.type = type;
    }
    public void printInstrument(){
        System.out.println("Name: " + this.name
                + ", Prize: " + this.prize
                + ", Type: " + this.type);
    }
}
