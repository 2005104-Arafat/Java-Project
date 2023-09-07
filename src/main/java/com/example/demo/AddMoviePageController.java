package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddMoviePageController {

    MainApplication mainApplication;
    public void setMainMenu(MainApplication mainApplication) {
        this.mainApplication=mainApplication;
    }
    @FXML
    Label Done,Alert;
    @FXML
    TextField addTitle;
    @FXML
    TextField addYear;
    @FXML
    TextField addTime;
    @FXML
    TextField addGenre1;
    @FXML
    TextField addGenre2;
    @FXML
    TextField addGenre3;
    @FXML
    TextField addBudget;
    @FXML
    TextField addRevenue;
    public void clickOnAdd(ActionEvent event)throws IOException {
        int state=0;
        for (movies m:MainApplication.MainList) {
            if(m.getName().equalsIgnoreCase(addTitle.getText())){
                state=1;
            }
        }
        if(addTitle.getText().isEmpty() || addTime.getText().isEmpty() || addYear.getText().isEmpty() || addGenre1.getText().isEmpty() || addBudget.getText().isEmpty()
        || addRevenue.getText().isEmpty()){
            Alert.setText("Invalid Movie Input!!!");
            Alert.setVisible(true);
            Done.setVisible(false);
        }
//        else if(state==1){
//            Alert.setText("Movie Already Exists");
//            Alert.setVisible(true);
//            Done.setVisible(false);
//        }
           else{
               if(state==0) {
                   System.out.println("dsfdga");
                   Done.setVisible(true);
                   Alert.setVisible(false);
                   String movieTitle = addTitle.getText();

                   int movieYear = Integer.parseInt(addYear.getText(), 10);
                   int movieTime = Integer.parseInt(addTime.getText(), 10);
                   String movieGenre1 = addGenre1.getText();
                   String movieGenre2 = addGenre2.getText();
                   String movieGenre3 = addGenre3.getText();
                   long movieBudget = Long.parseLong(addBudget.getText());
                   long movieRevenue = Long.parseLong(addRevenue.getText());
                   for (movies m : MainApplication.MainList) {
                       System.out.println(m.getName());
                   }
                   movies newMovie = new movies(movieTitle, movieYear, movieGenre1, movieGenre2, movieGenre3, movieTime, MainApplication.MainList.get(0).getProductionCompany(), movieBudget, movieRevenue);
                   MainApplication.socketWrapper.write(newMovie);
                   for (movies m : MainApplication.MainList) {
                       System.out.println(m.getName());
                   }
               }
        }
    }

    public void clickOnBack(ActionEvent event)throws IOException {
        mainApplication.goToSearchOptions();
    }
}

