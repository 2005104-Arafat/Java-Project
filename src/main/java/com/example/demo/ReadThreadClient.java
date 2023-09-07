package com.example.demo;
import com.example.demo.SocketWrapper;
import javafx.application.Application;
import javafx.application.Platform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReadThreadClient implements Runnable{
    //private final SocketWrapper socketWrapper;
    private ArrayList<movies> movielist;
    MainApplication application;

    public ReadThreadClient(MainApplication application) {
//        this.socketWrapper = socketWrapper;
        this.application=application;
        new  Thread(this).start();
        }
        @Override
        public void run() {
            try {
                while (true) {
                    Object o = MainApplication.socketWrapper.read();
                    if (o instanceof ArrayList) {
                        movielist = (ArrayList<movies>) o;
                        MainApplication.MainList=movielist;
                        ArrayList<movies> sorted= MainApplication.MainList;
                        Collections.sort(sorted, new SortbyYear());
                        int x= sorted.get(0).getReleaseYear();
                        for (movies m:sorted) {
                            if(x==m.getReleaseYear()){
                                MainApplication.sortedYearList.add(m);
                            }
                        }
                        ArrayList<movies> revenueList=MainApplication.MainList;
                        Collections.sort(revenueList, new SortbyRevenue());
                        long maxRevenue=revenueList.get(0).getRevenue();
                        for (movies m:revenueList) {
                            if(maxRevenue==m.getRevenue()){
                                MainApplication.sortedRevenueList.add(m);
                            }
                        }
                        //logInController loginController=new logInController();
                        //loginController.setMovieList(movielist);
                        System.out.println(movielist.size());
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    application.goToSearchOptions();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                        System.out.println("READ");

                        for (movies x1: movielist)
                        {
                            System.out.println(x1.getName());

                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    MainApplication.socketWrapper.closeConnection();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
class SortbyYear implements Comparator<movies> {

    // Method
    // Sorting in ascending order of roll number
    public int compare(movies a, movies b)
    {
        return b.getReleaseYear()-a.getReleaseYear();
    }
}
class SortbyRevenue implements Comparator<movies> {

    // Method
    // Sorting in ascending order of roll number
    public int compare(movies a, movies b)
    {

        return (int)(b.getRevenue()-a.getRevenue());
    }
}

