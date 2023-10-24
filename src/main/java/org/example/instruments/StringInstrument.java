package org.example.instruments;

public class StringInstrument extends Instrument{
    private String subType;
    private int amountOfStrings;

    public String getSubType() {
        return subType;
    }
    public void setSubType(String subType) {
        this.subType = subType;
    }
    public int getAmountOfStrings() {
        return amountOfStrings;
    }
    public void setAmountOfStrings(int amountOfStrings) {
        this.amountOfStrings = amountOfStrings;
    }

    public StringInstrument(){
        this.name = "String instrument";
        this.prize = 00.00;
        this.type = "String";
        this.subType = "Bow/plucked";
        this.amountOfStrings = 0;
    }
    public StringInstrument(String name, double prize, String type, String subType, int amountOfStrings){
        this.name = name;
        this.prize = prize;
        this.type = type;
        this.subType = subType;
        this.amountOfStrings = amountOfStrings;
    }

    public void printInstrument(){
        System.out.println("Name: " + this.name
                + ", Prize: " + this.prize
                + ", Type: " + this.type
                + ", Sub Type: " + this.subType
                + ", Amount of strings: " + this.amountOfStrings);
    }
}
