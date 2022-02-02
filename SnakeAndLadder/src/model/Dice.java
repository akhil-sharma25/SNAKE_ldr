package model;
public class Dice {
    int maxValue;
    int minValue;
    int currentVal;

    public Dice(int i, int i1, int i2) {
        maxValue = i1;
        minValue = i;
        currentVal = i2;
    }

    int roll(){
        return (int)(Math.random()*(this.maxValue-this.minValue+1)+this.minValue);
    }
}
