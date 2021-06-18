package FinalExam;

import SE221.Pair;

public class Wall {
    private int startingY;
    private int startingX;
    private int endingY;
    private int endingX;


    public Wall(int startingY, int startingX, int endingY, int endingX) {
        this.startingY = startingY;
        this.startingX = startingX;
        this.endingY = endingY;
        this.endingX = endingX;
    }

    public Wall() {
        this.startingY = 0;
        this.startingX = 0;
        this.endingY = 0;
        this.endingX = 0;
    }

    public int getStartingY() {
        return startingY;
    }

    public void setStartingY(int startingY) {
        this.startingY = startingY;
    }

    public int getStartingX() {
        return startingX;
    }

    public void setStartingX(int startingX) {
        this.startingX = startingX;
    }

    public int getEndingY() {
        return endingY;
    }

    public void setEndingY(int endingY) {
        this.endingY = endingY;
    }

    public int getEndingX() {
        return endingX;
    }

    public void setEndingX(int endingX) {
        this.endingX = endingX;
    }
}
