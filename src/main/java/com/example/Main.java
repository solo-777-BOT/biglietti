package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket ss= new ServerSocket(3000);
            Biglietti b= new Biglietti(10, 30, 60);
            do {
                Socket s = ss.accept();
                MioThread t = new MioThread(s,b);
                t.start();
            } while (true);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}