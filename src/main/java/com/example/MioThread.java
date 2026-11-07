package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MioThread extends Thread{
    private Socket  s;
    private Biglietti b;
    BufferedReader in;
    PrintWriter out;

    public MioThread(Socket s,Biglietti b){
        this.s=s;
        this.b=b;
    }
    public boolean login() throws IOException{
        String string=in.readLine();
        String login[]= string.split(" ");

        if(login.length==2){
            if(login[0].equalsIgnoreCase("login")){
                out.println("OK");
                return true;
            }else{
                out.println("ERR LOGINREQUIRED");
                return false;
            }
        }else{
            out.println("ERR SYNTAX");
            return false;
        }
    }
    public void run(){
        
    }
    
}
