package com.samistine.school.java2.unit07;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paperspace
 */
public class NameLookupClient {

    public static void main(String args[]) {
        int port = 8000;
        String host = "127.0.0.1";

        int dataToSend = 7000123;

        try {
            //connect to server 
            Socket socket = new Socket(host, port);
            DataInputStream feedbackFromServer = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToServer = new DataOutputStream(socket.getOutputStream());

            //write the data to the output stream
            outputToServer.writeLong(dataToSend);
            //flush it to the server
            outputToServer.flush();

            //display returned message
            System.out.println("Recieved: " + feedbackFromServer.readUTF());

        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end of main()
}
