package com.example.demo;

import javafx.event.ActionEvent;

import java.io.IOException;

public class SearchOptionPageController {
    MainApplication mainMenu=new MainApplication();

    public void setMainMenu(MainApplication mainMenu) {
        this.mainMenu = mainMenu;
    }

    public void clickOnLogOut(ActionEvent event)throws IOException{
          mainMenu.MainMenu();
    }
    public void clickOnAllMovies(ActionEvent event)throws IOException{
        mainMenu.goToAllMoviesPage();
    }
    public void clickOnRecentMovies(ActionEvent event)throws IOException{
        mainMenu.goToRecentMoviesPage();
    }
    public void clickOnMaximumRevenue(ActionEvent event)throws IOException{
        mainMenu.goToMaximumRevenuePage();
    }
    public void clickOnTotalProfit(ActionEvent event)throws IOException{
        mainMenu.goToTotalProfitPage();
    }
    public void clickOnAddMovie(ActionEvent event)throws IOException{
        mainMenu.goToAddMoviesPage();
    }
    public void clickOnTransferMovie(ActionEvent event)throws IOException{
        mainMenu.goToTransferMoviesPage();
    }
}
