package com.samistine.school.java2.unit07;

//import java.awt.Color;
//import java.awt.GraphicsEnvironment;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

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
public class NameLookupClient {

    //todo add header and add inputbox for users
    public static void main(String args[]) throws IOException {
        NameLookupClient nameLookupClient = new NameLookupClient(new InetSocketAddress("localhost", 8080));
        System.out.println("com.samistine.school.java2.unit07.NameLookupClient.main()");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                //Tempt user
                System.out.print("Student ID: ");
                //Get input
                long id = scanner.nextLong();
                //Query Service
                Optional<String> lookup = nameLookupClient.lookup(id);
                //Display Result
                System.out.println(" " + lookup.map(name -> "Student's name: " + name).orElse("Student Not Found"));
            } catch (InputMismatchException ex) {
                System.out.println(" Invalid ID. Try again.");
                // Eat the new line
                scanner.nextLine();
            }
        }
//        Console console = new Console();
//        while (true) {
//            try {
//                //Tempt user
//                console.println("\nEnter Student ID");
//                //Get input
//                Optional<Long> id = console.nextLineAsLong();
//
//                if (!id.isPresent()) {
//                    console.println("Invalid ID, Try Again with a valid set of digits", false, Color.RED);
//                    continue;
//                }
//
//                //Query Service
//                Optional<String> lookup = nameLookupClient.lookup(id.get());
//                //Display Result
//                if (lookup.isPresent()) {
//                    console.println("Student's name: " + lookup.get(), false, Color.GREEN);
//                } else {
//                    console.println("Student Not Found", false, Color.RED);
//                }
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }

    } // end of main()

    public final SocketAddress address;
    private Socket socket;
    private DataInputStream feedbackFromServer;
    private DataOutputStream outputToServer;

    public NameLookupClient(InetSocketAddress address) {
        this.address = address;
    }

    //Setup fresh connection to server
    void connect() throws IOException {
        //connect to server
        socket = new Socket();
        socket.connect(address);

        //Setup streams
        feedbackFromServer = new DataInputStream(socket.getInputStream());
        outputToServer = new DataOutputStream(socket.getOutputStream());
    }

    //tidy up and close connection
    void disconnect() throws IOException {
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
    }

    public Optional<String> lookup(long id) throws IOException {
        try {
            connect();//begin

            //write the data to the output stream
            outputToServer.writeLong(id);
            //flush it to the server
            outputToServer.flush();

            //get returned message
            final String msgFromServer = feedbackFromServer.readUTF();

            if (msgFromServer.equalsIgnoreCase("null")) {
                return Optional.empty();
            } else {
                return Optional.of(msgFromServer);
            }

        } finally {
            disconnect();//end
        }
    }

}
