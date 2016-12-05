package com.samistine.school.java2.unit07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
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

/**
 * Class: CIST 2372 Java II
 * Quarter: Fall 2016
 * Instructor: Dave Busse
 * Project: Unit07
 * Date: Created December 4, 2016 7:54:00 PM
 *
 * By turning in this code, I Pledge:
 * 1. That I have completed the programming assignment independently.
 * 2. I have not copied the code from a student or any source other than my own.
 * 3. I have not given my code to any student.
 *
 * @author Samuel Seidel <samuel@samistine.com>
 * @version 1.0
 */
public class NameLookupServer implements Runnable {

    static final Logger LOGGER = Logger.getGlobal();
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
        //System.getenv().put("java.util.logging.SimpleFormatter.format", "%4$s: %5$s%6$s%n");
        //http://docs.oracle.com/javase/7/docs/api/index.html?java/util/logging/SimpleFormatter.html
        //System.setProperty("java.util.logging.SimpleFormatter.format","[%1$tY/%1$tm/%1$td %1$tH:%1$tM:%1$tS] [%4$s] %5$s%6$s%n");
        System.setProperty("java.util.logging.SimpleFormatter.format","[%4$s] %5$s%6$s%n");
        new NameLookupServer(new InetSocketAddress(8080)).run();
    }

    /* Address we shall listen to */
    public InetSocketAddress address;
    /* ExecutorService for async and multithreaded response handling */
    final ExecutorService exec = Executors.newWorkStealingPool();
    /* The ServerSocket to be used to listen for clients */
    final ServerSocket serverSocket;
    /* While this is true we run */
    volatile boolean running = true;

    public NameLookupServer(InetSocketAddress address) throws IOException {
        this.address = address;
        this.serverSocket = new ServerSocket();
    }

    public void shutdown() {
        this.running = false;
    }

    @Override
    public void run() {
        try {
            //Bind socket to socketaddress
            serverSocket.bind(address);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        LOGGER.log(Level.INFO, "Server started on {0}", serverSocket);
        System.out.println("Current time is " + new Date().toGMTString());
        System.out.println("Current local time is " + new Date().toLocaleString());

        /* Work Loop */
        while (running) {

            try {
                //Wait for an incoming connection
                final Socket socket = serverSocket.accept();

                LOGGER.log(Level.INFO, " Incoming connection {0}", socket);

                //Create a handler for the socket
                final SocketHandler socketHandler = new SocketHandler(socket);

                //Submit the handler to be executed off-thread by our threadpool
                exec.submit(socketHandler);
            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "An error occured while accepting an incoming connection.", ex);
            }

        }
        //END Work Loop

        //Begin shutdown logic
        try {
            //Shutdown listening socket
            serverSocket.close();
        } catch (IOException ex) {
            LOGGER.log(Level.SEVERE, "Failed to close server socket.", ex);
        }

        //Signal thread pool to shutdown
        exec.shutdown();
        try {
            //now wait for it to do so
            exec.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            LOGGER.log(Level.SEVERE, "Termination took too long (> 10 seconds).", ex);
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
                final DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                final DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                try {
                    //get the id that the client sends us
                    final long id = inputFromClient.readLong();

                    LOGGER.log(Level.INFO, "   ID: {0} recieved from {1}", new Object[]{id, socket});

                    //lookup student for the provided id
                    String student = STUDENTS.get(id);
                    {
                        //Add default case incase no student found
                        if (student == null) {
                            student = "NULL";
                        }
                    }

                    //send student to client
                    outputToClient.writeUTF(student);
                    LOGGER.log(Level.INFO, "    Sending back {0} to {1}", new Object[]{student, socket});

                    //flush response out to client
                    outputToClient.flush();

                } catch (EOFException ex) {
                    LOGGER.info("   Client sent invalid request.");
                    outputToClient.writeUTF("Invalid Request. Please send an encoded java long (Eight Bytes)!");
                }

            } catch (IOException ex) {
                LOGGER.log(Level.SEVERE, "Failed to handle connection! for " + socket, ex);
            } finally {
                /* attempt to flush output, close input and output, and finally close the socket */
                try {
                    socket.shutdownInput();
                    socket.shutdownOutput();
                    socket.close();
                } catch (IOException ex) {
                    LOGGER.log(Level.SEVERE, "Couldn't close socket! for " + socket, ex);
                }
            }
        }

    }

}
