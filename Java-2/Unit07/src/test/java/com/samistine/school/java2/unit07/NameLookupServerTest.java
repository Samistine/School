/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.school.java2.unit07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author paperspace
 */
@RunWith(Parameterized.class)
public class NameLookupServerTest {

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[1_000][0]);
    }

    static int port;
    static String host = "127.0.0.1";
    static int dataToSend = 7000123;
    static String expectedResult = "John Doe";

    static NameLookupServer server;

    @BeforeClass
    public static void initServer() throws IOException {
        //Determine port
        try (ServerSocket ss = new ServerSocket(0)) {
            port = ss.getLocalPort();
        }

        server = new NameLookupServer(port);
        new Thread(server).start();
    }

    @AfterClass
    public static void stopServer() {
        server.shutdown();
    }

    Socket socket;
    DataInputStream feedbackFromServer;
    DataOutputStream outputToServer;

    @Before
    public void setUp() throws IOException {
        //connect to server 
        socket = new Socket(host, port);
        feedbackFromServer = new DataInputStream(socket.getInputStream());
        outputToServer = new DataOutputStream(socket.getOutputStream());
    }

    @After
    public void tearDown() throws IOException {
        socket.close();
    }

    @org.junit.Test
    public void testDataStreamLong() throws IOException {
        //write the data to the output stream
        outputToServer.writeLong(dataToSend);
        //flush it to the server
        outputToServer.flush();
        //Response
        String response = feedbackFromServer.readUTF();
        //display returned message
        System.out.println("        Recieved: " + response);
        assertEquals(expectedResult, response);
    }

}
