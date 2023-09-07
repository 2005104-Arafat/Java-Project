package com.example.demo;

import java.io.Serializable;

public class movies implements Serializable {
    private String Name;
    private int ReleaseYear;
    private String Genre1;
    private String Genre2;
    private String Genre3;
    private int RunningTime;
    private String ProductionCompany;
    private long Budget;
    private long Revenue;
    private long Profit;

    public  movies(){}
    public movies(String name, int releaseYear, String genre1, String genre2, String genre3, int runningTime, String productionCompany, long budget, long revenue){

        this.Name = name;
        this.ReleaseYear = releaseYear;
        this.Genre1 = genre1;
        this.Genre2 = genre2;
        this.Genre3 = genre3;
        this.RunningTime = runningTime;
        this.ProductionCompany = productionCompany;
        this.Budget = budget;
        this.Revenue = revenue;
        Profit=this.Revenue-this.Budget;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }

    public void setBudget(long budget) {
        Budget = budget;
    }

    public void setRevenue(long revenue) {
        Revenue = revenue;
    }

    public String getName() {
        return Name;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }

    public long getBudget() {
        return Budget;
    }

    public long getRevenue() {
        return Revenue;
    }
    public long getProfit(){return Profit;}
}
