package ServerPackage;
import com.example.demo.*;

import java.io.IOException;
import java.util.*;

public class ServerReadThread implements Runnable {
    private final SocketWrapper socketWrapper;
    HashMap<String,SocketWrapper> clientmap=new HashMap<>();

    public ServerReadThread(SocketWrapper socketWrapper,HashMap<String,SocketWrapper> clientmap) {
        this.socketWrapper = socketWrapper;
        Thread thr = new Thread(this);
        this.clientmap = clientmap;
        System.out.println("in read thread");
        thr.start();
    }
    public void run() {
        Methods method= new Methods();
        try {
            method.adding();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String companyName=new String();

        movies latestMovie;

        try {
           while (true) {
                Object o = socketWrapper.read();
                if (o instanceof movies) {
                    latestMovie = (movies) o;
                    System.out.println(latestMovie.getName());
                    method.movieList.add(latestMovie);
                    //MainApplication.MainList.add(latestMovie);
                    socketWrapper.write(method.searchCompany(companyName));
                }
                if (o instanceof String) {
                    companyName = (String) o;
                    boolean state = false;
                    for (movies m : method.movieList) {
                        if (companyName.equalsIgnoreCase(m.getProductionCompany())) {
                            state = true;
                            break;
                        }
                    }
                    if (state) {
                        try {
                            System.out.println(method.movieList.size());
                            clientmap.put(companyName.toUpperCase(),socketWrapper);
                            socketWrapper.write(method.searchCompany(companyName));
                            System.out.println(clientmap.size());
                            System.out.println(clientmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
//                        finally {
//                            Methods.movieList.clear();
//                        }
                    }
                    else {
                        try {
                            socketWrapper.write("This name is not valid");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if(o instanceof Transfer){
                    Transfer transfer=(Transfer) o;
                    List<movies> removedList= method.searchCompany(companyName);
                    removedList.remove(method.searchTitle(transfer.getMovieName()));
                    socketWrapper.write(removedList);
                    List<movies> list=new ArrayList<>();
                    list=method.searchCompany(transfer.getCompanyName());
                    System.out.println(method.searchTitle(transfer.getMovieName()));
                    method.searchTitle(transfer.getMovieName()).setProductionCompany(transfer.getCompanyName());
                    list.add(method.searchTitle(transfer.getMovieName()));
                    clientmap.get(transfer.getCompanyName().toUpperCase()).write(list);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
