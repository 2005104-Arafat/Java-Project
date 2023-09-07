package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecentMoviesPageController implements Initializable {
    MainApplication mainApplication;
    public void setMainMenu(MainApplication mainApplication) {
        this.mainApplication=mainApplication;
    }
    @FXML
    private TableView<movies> table;
    @FXML
    private TableColumn<movies,String> name,releaseYear,genre1,genre2,genre3,runningTime,budget,revenue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<movies> movieObservableList= FXCollections.observableArrayList();

        //System.out.println(list.get(0).getName());
        for(movies movie:MainApplication.sortedYearList)
        {
            movieObservableList.add(movie);
        }
        name.setCellValueFactory(new PropertyValueFactory<movies,String>("Name"));
        releaseYear.setCellValueFactory(new PropertyValueFactory<movies,String>("ReleaseYear"));
        genre1.setCellValueFactory(new PropertyValueFactory<movies,String>("Genre1"));
        genre2.setCellValueFactory(new PropertyValueFactory<movies,String>("Genre2"));
        genre3.setCellValueFactory(new PropertyValueFactory<movies,String>("Genre3"));
        runningTime.setCellValueFactory(new PropertyValueFactory<movies,String>("RunningTime"));
        budget.setCellValueFactory(new PropertyValueFactory<movies,String>("Budget"));
        revenue.setCellValueFactory(new PropertyValueFactory<movies,String>("Revenue"));
        table.setItems(movieObservableList);
    }

    public void clickOnBack(ActionEvent event) throws IOException {
        mainApplication.goToSearchOptions();
    }
}
