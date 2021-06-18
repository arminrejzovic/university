package com.company;

import java.util.Objects;

public class Team {
    private String teamName;
    private String member1;
    private String member2;
    private String member3;
    private String member4;
    private Competition competition1;
    private Competition competition2;


    public Team(String teamName, String member1, String member2, String member3, String member4, Competition competition1, Competition competition2) {
        this.teamName = teamName;
        this.member1 = member1;
        this.member2 = member2;
        this.member3 = member3;
        this.member4 = member4;
        this.competition1 = new Competition(competition1);
        this.competition2 = new Competition(competition2);
    }

    public Team(Team otherTeam) {
        if (otherTeam==null){
            System.out.println("Error: provided team is null");
            System.exit(0);
        }
        else {
            this.teamName = otherTeam.teamName;
            this.member1 = otherTeam.member1;
            this.member2 = otherTeam.member2;
            this.member3 = otherTeam.member3;
            this.member4 = otherTeam.member4;
            this.competition1 = new Competition(otherTeam.competition1);
            this.competition2 = new Competition(otherTeam.competition2);
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getMember3() {
        return member3;
    }

    public void setMember3(String member3) {
        this.member3 = member3;
    }

    public String getMember4() {
        return member4;
    }

    public void setMember4(String member4) {
        this.member4 = member4;
    }

    public Competition getCompetition1() {
        return new Competition(competition1);
    }

    public void setCompetition1(Competition competition1) {
        this.competition1 = new Competition(competition1);
    }

    public Competition getCompetition2() {
        return new Competition(competition2);
    }

    public void setCompetition2(Competition competition2) {
        this.competition2 = new Competition(competition2);
    }

    public boolean equals(Team otherTeam) {
        if (otherTeam == null) return false;
        else return this.teamName.equals(otherTeam.teamName) && this.member1.equals(otherTeam.member1)
                && this.member2.equals(otherTeam.member2) && this.member3.equals(otherTeam.member3)
                && this.member4.equals(otherTeam.member4) && this.competition1.equals(otherTeam.competition1)
                && this.competition2.equals(otherTeam.competition2);
    }

    @Override
    public String toString() {
        return "TEAM INFORMATION:\n" +
                "Team Name: " + teamName +
                ", Member 1: " + member1 +
                ", Member 2: " + member2 +
                ", Member 3: " + member3 +
                ", Member 4: " + member4 +
                ", 1st Competition: " + competition1 +
                ", 2nd Competition: " + competition2;
    }

    public void printTeam(){
        System.out.println(this.toString());
    }

    public static void main(String[] args) {
        Team team1 = new Team("Team ABC","John","Adam","Bill","Sean",
                new Competition("C++ Competition","Team ABC","Team DEF",2019),
                new Competition("Java Competition","Team DEF","Team ABC",2019));

        Team team2 = new Team("Team DEF","Jeff","Steve","Bob","Jack",
                new Competition("Java Competition","Team DEF","Team ABC",2019),
                new Competition("C++ Competition","Team ABC","Team DEF",2019));

        Team team3 = new Team(team2);
        team3.setTeamName("Team CC");
        team3.setMember2("Not Steve");
        team3.setCompetition1(new Competition("Kotlin Competition","Team CC","Team DEF",2018));
        team3.setCompetition2(new Competition("C# Competition","Team ABC","Team CC",2018));

        System.out.println("TEAM 2: \n"+team2.toString());
        System.out.println("TEAM 3: \n"+team3.toString());

    }

}
