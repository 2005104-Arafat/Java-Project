package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class MainApplication extends Application {
    public static SocketWrapper socketWrapper;
    public static ArrayList<movies> MainList=new ArrayList<>();
    public static ArrayList<movies> sortedYearList= new ArrayList<>();
    public static ArrayList<movies> sortedRevenueList= new ArrayList<>();


    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;

        MainMenu();
    }
    public void connectToserver() throws IOException {
        socketWrapper = new SocketWrapper("127.0.0.1", 44456);
        new ReadThreadClient(this);
    }
    public void MainMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        logInController loginController=fxmlLoader.getController();
        loginController.setApplication(this);
        stage.setTitle("Log in page");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToSearchOptions() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("SearchOptionPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        SearchOptionPageController searchController=fxmlLoader.getController();
        searchController.setMainMenu(this);
        stage.setTitle("Search Menu");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToAllMoviesPage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AllMoviesPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        AllMoviesPageController allMoviesController=fxmlLoader.getController();
        allMoviesController.setMainMenu(this);
        stage.setTitle("All Movies");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToRecentMoviesPage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("RecentMoviesPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        RecentMoviesPageController recentMoviesController=fxmlLoader.getController();
        recentMoviesController.setMainMenu(this);
        stage.setTitle("Recent Movies");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToMaximumRevenuePage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("MaximumRevenuePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        MaximumRevenuePageController maximumRevenueController=fxmlLoader.getController();
        maximumRevenueController.setMainMenu(this);
        stage.setTitle("Maximum Revenue");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToTotalProfitPage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("TotalProfitPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        TotalProfitPageController totalProfitController=fxmlLoader.getController();
        totalProfitController.setMainMenu(this);
        stage.setTitle("Total Profit");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToAddMoviesPage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AddMoviePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        AddMoviePageController addMovieController=fxmlLoader.getController();
        addMovieController.setMainMenu(this);
        stage.setTitle("Add Movie");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public void goToTransferMoviesPage()throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("TransferMoviePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 720);
        TransferMoviePageController transferMovieController=fxmlLoader.getController();
        transferMovieController.setMainMenu(this);
        stage.setTitle("Transfer Movies");
        stage.setResizable(false);
        stage.setFullScreen(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}