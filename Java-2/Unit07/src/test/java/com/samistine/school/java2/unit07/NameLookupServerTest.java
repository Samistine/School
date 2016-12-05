/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samistine.school.java2.unit07;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Optional;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;

/**
 *
 * @author paperspace
 */
public class NameLookupServerTest {
    
    static {
        System.setProperty("java.util.logging.SimpleFormatter.format"," ~ %5$s%6$s%n");
    }

    static InetSocketAddress address;
    static int dataToSend = 7000123;
    static String expectedResult = "John Doe";

    static NameLookupServer server;

    @BeforeClass
    public static void initServer() throws IOException, InterruptedException {
        address = new InetSocketAddress(19123);
        System.out.println("Using " + address);

        System.out.println("Initializing Server");
        server = new NameLookupServer(address);

        System.out.println("Starting Server\n");
        new Thread(server).start();
        Thread.sleep(100);//Allow server to start
    }

    @AfterClass
    public static void stopServer() {
        server.shutdown();
    }

    NameLookupClient client;

    @Before
    public void setUp() throws IOException {
        //Init NameLookupClient
        client = new NameLookupClient(address);
    }

    @org.junit.Test
    public void testConnect() throws IOException {
        System.out.println("\nTesting testConnect()");
        System.out.println("Connecting");
        client.connect();
    }

    @org.junit.Test
    public void testDisconnect() throws IOException {
        System.out.println("\nTesting testDisconnect()");
        System.out.println("Connecting");
        client.connect();
        System.out.println("Disconnecting");
        client.disconnect();
    }

    @org.junit.Test
    public void testLookup() throws IOException {
        System.out.println("\nTesting testLookup()");
        //Query
        Optional<String> response = client.lookup(dataToSend);
        //display returned message
        System.out.println("Recieved: " + response);
        assertEquals(expectedResult, response.orElse(null));
    }

    @org.junit.Test
    public void testLookup2() throws IOException {
        System.out.println("\nTesting testLookup2()");
        //Query
        Optional<String> response = client.lookup(-1);
        //display returned message
        System.out.println("Recieved: " + response);
        assertEquals(null, response.orElse(null));
    }

}
