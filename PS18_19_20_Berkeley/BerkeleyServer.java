import java.io.*;
import java.net.*;
import java.util.*;

public class BerkeleyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started. Waiting for client...");

        Socket client = server.accept();
        System.out.println("Client connected!");

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        // Server's current time
        long serverTime = System.currentTimeMillis();
        System.out.println("Server Time: " + serverTime);

        // Receive client's time
        long clientTime = dis.readLong();
        System.out.println("Client Time: " + clientTime);

        // Calculate average
        long avgTime = (serverTime + clientTime) / 2;
        System.out.println("Average Time: " + avgTime);

        // Send offset to client
        long offset = avgTime - clientTime;
        dos.writeLong(offset);

        // Server also adjusts its clock (simulation)
        System.out.println("Server clock adjustment by " + (avgTime - serverTime) + " ms");

        dis.close();
        dos.close();
        client.close();
        server.close();
    }
}

/*
 * Steps to Run the Code

On Server Machine:

Save code as Server.java.

Compile using: javac Server.java

Run using: java Server

On Client Machine:

Save code as Client.java.

Change SERVER_IP to the server's actual IP address.

Compile using: javac Client.java

Run using: java Client
 */
