package org.example.instruments;

public class WindInstrument extends Instrument{
    private int length;
    private String subType;

    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public WindInstrument(){
        this.name = "Wind instrument";
        this.prize = 00.00;
        this.type = "Wind";
        this.length = 0;
        this.subType = "Woodwind";
    }
    public WindInstrument(String name, double prize, String type, String subType, int length){
        this.name = name;
        this.prize = prize;
        this.type = type;
        this.length = length;
        this.subType = subType;
    }

    public void printInstrument() {
        System.out.println("Name: " + this.name
                + ", Prize: " + this.prize
                + ", Type: " + this.type
                + ", Sub Type: " + this.subType
                + ", Length: " + this.length);
    }
}
