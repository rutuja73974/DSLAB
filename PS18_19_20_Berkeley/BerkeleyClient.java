import java.io.*;
import java.net.*;

public class BerkeleyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.211.62", 5000); // replace SERVER_IP_ADDRESS with Server's IP

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        // Client's current time
        long clientTime = System.currentTimeMillis();
        System.out.println("Client Time: " + clientTime);

        // Send client time to server
        dos.writeLong(clientTime);

        // Receive offset from server
        long offset = dis.readLong();
        System.out.println("Client clock adjustment by " + offset + " ms");

        dis.close();
        dos.close();
        socket.close();
    }
}

// Steps to Run the Code

// On Server Machine:

// Save code as Server.java.

// Compile using: javac Server.java

// Run using: java Server

// On Client Machine:

// Save code as Client.java.

// Change SERVER_IP to the server's actual IP address.

// Compile using: javac Client.java

// Run using: java Client
