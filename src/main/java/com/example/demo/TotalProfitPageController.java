package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfitPageController implements Initializable {
    public TableView<movies> totalProfit;
    public TableColumn<movies,String> name;
    public TableColumn<movies,Long> revenue;
    public TableColumn<movies,Long> profit;
    public TableColumn<movies,Long> budget;
    public Label lebel2;
    MainApplication mainApplication;
    public void setMainMenu(MainApplication mainApplication) {
        this.mainApplication=mainApplication;
    }
    //@FXML
    //private TableView<movies> table;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        long sum =0;

        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        budget.setCellValueFactory(new PropertyValueFactory<>("Budget"));
        revenue.setCellValueFactory(new PropertyValueFactory<>("Revenue"));
        profit.setCellValueFactory(new PropertyValueFactory<>("Profit"));

        for(movies object : MainApplication.MainList){
            totalProfit.getItems().add(object);
            sum+=object.getProfit();
        }
        lebel2.setText(Long.toString(sum));

    }

    public void clickOnBack(ActionEvent event)throws IOException {
        mainApplication.goToSearchOptions();
    }
}
