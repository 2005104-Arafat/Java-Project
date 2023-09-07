package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class TransferMoviePageController implements Initializable {
    @FXML
    ChoiceBox<String> movieName, companyName;


    MainApplication mainApplication;

    public void setMainMenu(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    public void clickOnTransfer(ActionEvent event) {

        Transfer transferMovie = new Transfer(movieName.getValue(), companyName.getValue());
        try {
            MainApplication.socketWrapper.write(transferMovie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickOnBack(ActionEvent event) throws IOException {
        mainApplication.goToSearchOptions();
    }

        @Override
    public void initialize(URL location, ResourceBundle resources){
            for (movies m : MainApplication.MainList) {
                movieName.getItems().add(m.getName());
            }
            Methods companyMethod = new Methods();
            try {
                companyMethod.adding();
                ArrayList<String> companyList = new ArrayList<>();
                for (movies m : companyMethod.movieList) {
                    companyList.add(m.getProductionCompany());
                }
                Set<String> newList = new HashSet<>(companyList);
                for (String s : newList) {
                    companyName.getItems().add(s);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
