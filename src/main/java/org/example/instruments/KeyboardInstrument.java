package org.example.instruments;

public class KeyboardInstrument extends Instrument{
    private int amountOfPolyfonias;
    public int getAmountOfPolyfonias() {
        return amountOfPolyfonias;
    }
    public void setAmountOfPolyfonias(int amountOfPolyfonias) {
        this.amountOfPolyfonias = amountOfPolyfonias;
    }

    public KeyboardInstrument(){
        super();
        this.amountOfPolyfonias = 0;
    }
    public KeyboardInstrument(String name, double prize, String type, int amountOfKeys){
        super(name, prize, type);
        this.amountOfPolyfonias = amountOfKeys;
    }

    public void printInstrument(){
        System.out.println("Name: " + this.name
                + ", Prize: " + this.prize
                + ", Type: " + this.type
                + ", Amount of polyfonia: " + this.amountOfPolyfonias);
    }
}
