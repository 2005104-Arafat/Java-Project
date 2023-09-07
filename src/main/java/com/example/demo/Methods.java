package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Methods implements Serializable {
    public  ArrayList<movies> movieList = new ArrayList<>();
    final String INPUT_FILE_NAME = "movies.txt";
    public void adding ()throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            String[] out = line.split(",");

            movies movieInfo = new movies(out[0], Integer.parseInt(out[1], 10), out[2], out[3], out[4], Integer.parseInt(out[5], 10), out[6], Long.parseLong(out[7], 10), Long.parseLong(out[8], 10));
            movieList.add(movieInfo);
            //System.out.println(movieInfo.getName());
        }
        br.close();
    }
    public List<movies> searchCompany(String searchCompany){
        List<movies> t1= new ArrayList();
        int flag=0;
        for(int i = 0; i < movieList.size(); i++){
            movies t =movieList.get(i);
            if (t.getProductionCompany().equalsIgnoreCase(searchCompany)) {
                t1.add(t);
                flag=1;
            }
        }
        if(flag==0){
            return null;
        }else{
            return t1;
        }
    }
    public movies searchTitle(String searchName){
        System.out.println(movieList.size());
        for (int i = 0; i < movieList.size(); i++) {
            movies t =movieList.get(i);
            if (t.getName().equalsIgnoreCase(searchName)) return t;
        }
        return null;
    }
}