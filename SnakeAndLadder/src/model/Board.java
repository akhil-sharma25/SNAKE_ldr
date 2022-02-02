package model;
public class Board {
    int size;
    int startPoint;
    int endPoint;

    public Board(int size, int maxValue, int minValue) {
        this.endPoint=maxValue;
        this.size=size;
        this.startPoint=minValue;
    }
}
