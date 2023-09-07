package com.example.demo;

import java.io.Serializable;

public class Transfer implements Serializable {
    private String movieName;
    private String companyName;
    public Transfer(String movieName,String companyName){
        this.movieName=movieName;
        this.companyName=companyName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
