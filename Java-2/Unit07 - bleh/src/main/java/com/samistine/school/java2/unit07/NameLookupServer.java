package com.samistine.school.java2.unit07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paperspace
 */
public class NameLookupServer implements Runnable {

    static final Map<Long, String> STUDENTS = Collections.unmodifiableMap(new HashMap<Long, String>() {
        {
            put(7000123L, "John Doe");
            put(7000453L, "Mary Smith");
            put(7000677L, "G. Washington");
            put(7000799L, "B. Franklin");
            put(7000388L, "B. Ford");
        }
    });

    public static void main(String[] args) throws IOException {
        System.out.println(STUDENTS.getClass());
        new NameLookupServer(8000).run();
    }

    final ExecutorService exec = Executors.newWorkStealingPool();
    final ServerSocket serverSocket;
    volatile boolean running = true;

    public NameLookupServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server started at " + new Date() + '\n');
    }

    public void shutdown() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                //Wait for an incoming connection
                Socket socket = serverSocket.accept();

                System.out.println(" Incoming connection " + socket);

                //Create a handler for the socket
                SocketHandler socketHandler = new SocketHandler(socket);

                //Submit the handler to be executed off-thread by our threadpool
                exec.submit(socketHandler);
            } catch (IOException ex) {
                Logger.getLogger(NameLookupServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //Begin shutdown logic

        try {
            //Shutdown listening socket
            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(NameLookupServer.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Signal thread pool to shutdown
        exec.shutdown();
        try {
            //now wait for it to do so
            exec.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(NameLookupServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    static class SocketHandler implements Runnable {

        final Socket socket;

        public SocketHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                try {
                    long id;

                    //inputFromClient.read();
                    final int length = inputFromClient.available();
                    System.out.println("  Received " + length + " initial bytes");
                    //get the id that the client sends us
                    //we handle multiple data types

                    switch (length) {
                        case 4://int
                            System.out.println("*4*");
                            id = inputFromClient.readInt();
                            break;
                        case 8://long
                            System.out.println("*8*");
                            id = inputFromClient.readLong();
                            break;
                        default://try objectstream
                            System.out.println("*def*");
                            id = -1;
                            ObjectInputStream objStream = new ObjectInputStream(inputFromClient);
                            switch (objStream.available()) {
                                case 4://int
                                    id = objStream.readInt();
                                    break;
                                case 8://long
                                    id = objStream.readLong();
                                    break;
                                default://assume String
                                    //double floats strings ehhh
                                    //assume if its one of them its a string
                                    id = Long.parseLong(objStream.readUTF());
                                    break;
                            }
                            break;
                    }

                    System.out.println("   ID: " + id + " recieved from " + socket);

                    //lookup student for the provided id
                    String student = STUDENTS.get(id);

                    //Add default case incase no student found
                    if (student == null) {
                        student = "NULL";
                    }

                    //send student to client
                    outputToClient.writeUTF(student);
                    System.out.println("    Sending back " + student + " to " + socket);

                    //flush response out to client
                    outputToClient.flush();

                } catch (EOFException ex) {
                    System.out.println("Client sent invalid request.");
                    outputToClient.writeUTF("Invalid Request. Please send an encoded java long (Eight Bytes)!");
                }

            } catch (Exception ex) {
                System.err.println("Failed to handle connection! for " + socket);
                ex.printStackTrace();
            } finally {
                try {
                    try {
                        //attempt to flush and close input and output streams
                        socket.shutdownInput();
                        socket.shutdownOutput();
                    } catch (Exception ex) {
                        System.err.println("Couldn't close input and output streams! for" + socket);
                        ex.printStackTrace();
                    }
                    //Close socket, regardless of what happened above
                    socket.close();
                } catch (IOException ex) {
                    System.err.println("Couldn't close socket! for " + socket);
                    ex.printStackTrace();
                }
            }
        }

    }

}
