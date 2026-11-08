package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
        try (BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);){
            this.in=in;
            this.out=out;
            out.println("WELCOME");
            do {
                if(login()){
                    String str=in.readLine();
                    if (str.equals("N")) {
                        out.println("AVAIL Gold:"+b.getGold()+ "Pit:"+ b.getPit() +"Parterre:"+b.getParterre());
                    } else if(str.equals("BUY")){
                        String acquisto= in.readLine();
                        String risultato[]=acquisto.split(" ", 2);
                        if(risultato.length==2){
                            try {
                                int numero=Integer.parseInt(risultato[1]);
                                if(b.acquista(risultato[0], numero)){
                                    out.println("OK");
                                }else{
                                    out.println("KO");
                                }
                            } catch (NumberFormatException ex) {
                                out.println("err syntax");
                            }catch(Exception e){
                                out.println("err unknown type");
                            }
                        }else{
                            out.println("err syntax");
                        }
                    }else if (str.equals("QUIT")) {
                        out.println("bye");
                        s.close();
                        break;
                    }
                }else{
                    out.println("err unknown cmd");
                    login();
                }
            } while (true);
        
        }catch (Exception e) {
            
        }
    }
}
