package org.example.instruments;

public class PercussionInstrument extends Instrument {
    private int diameter;
    public int getDiameter() {
        return diameter;
    }
    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public PercussionInstrument(){
        this.name = "Percussion instrument";
        this.prize = 00.00;
        this.type = "Percussion";
        this.diameter = 0;
    }
    public PercussionInstrument(String name, double prize, String type, int diameter){
        this.name = name;
        this.prize = prize;
        this.type = type;
        this.diameter = diameter;
    }

    public void printInstrument(){
        System.out.println("Name: " + this.name
                + ", Prize: " + this.prize
                + ", Type: " + this.type
                + ", Diameter: " + this.diameter);
    }
}
