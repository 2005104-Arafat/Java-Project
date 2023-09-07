package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class logInController {
    public Label LogInFailed;
    MainApplication mainApplication;
    public static ArrayList<movies> newList;
    @FXML
    TextField textField;
    SocketWrapper socketWrapper;

    public void logIn(ActionEvent actionEvent) throws IOException {
//        SocketWrapper client= new SocketWrapper("127.0.0.1",44456);
        mainApplication.connectToserver();
        MainApplication.socketWrapper.write(textField.getText());

        }

    public void setApplication(MainApplication mainApplication) {
        this.mainApplication= mainApplication;
    }



}