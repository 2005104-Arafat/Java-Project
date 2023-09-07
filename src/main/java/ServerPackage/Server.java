package ServerPackage;
import com.example.demo.Methods;
import com.example.demo.SocketWrapper;
import com.example.demo.movies;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;
import java.util.*;

public class Server {
    private ServerSocket serverSocket;
    HashMap<String,SocketWrapper> clientmap=new HashMap<>();


    Server() {
        try {
            serverSocket = new ServerSocket(44456);
            System.out.println("Server is waiting ... ");
            while (true) {
                try{
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Accepted");
//                    Methods method= new Methods();
//                    try {
//                        method.adding();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
                    serve(clientSocket);
                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    public void serve(Socket clientSocket) throws Exception {
     SocketWrapper newClient= new SocketWrapper(clientSocket);
     new ServerReadThread(newClient, clientmap);
    }

    public static void main(String[] args) {
        new Server();
    }

}