package com.company;

import java.util.Objects;

public class Competition {
    private String name;
    private String winner;
    private String runnerUp;
    private int year;

    public Competition() {
        name = "No name";
        winner = "No winner";
        runnerUp = "No runner-up";
        year = 0;
    }

    public Competition(String name, String winner, String runnerUp, int year) {
        this.name = name;
        this.winner = winner;
        this.runnerUp = runnerUp;
        setYear(year);
    }

    public Competition(Competition otherCompetition){
        if (otherCompetition==null){
            System.out.println("Error: Provided Competition is null");
            System.exit(0);
        }
        else{
            this.name=otherCompetition.name;
            this.winner=otherCompetition.winner;
            this.runnerUp=otherCompetition.runnerUp;
            this.year=otherCompetition.year;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getRunnerUp() {
        return runnerUp;
    }

    public void setRunnerUp(String runnerUp) {
        this.runnerUp = runnerUp;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year>=0){
            this.year = year;
        }
        else {
            System.out.println("Invalid input: year cannot be negative");
            System.exit(0);
        }

    }

    public boolean equals(Competition otherCompetiton) {
        if (otherCompetiton == null) return false;
        else {
            return year == otherCompetiton.year && this.runnerUp.equals(otherCompetiton.runnerUp)
                    && this.winner.equals(otherCompetiton.runnerUp) && this.name.equals(otherCompetiton.name);
        }
    }


    @Override
    public String toString() {
        return "COMPETITION INFORMATION: \n" +
                "Competition Name: " + name +
                ", Winner: " + winner +
                ", Runner Up: " + runnerUp +
                ", Year held: " + year;
    }
}
