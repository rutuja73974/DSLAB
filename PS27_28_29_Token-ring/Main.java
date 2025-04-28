import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] ids = {4, 2, 8, 6, 1}; // IDs of processes
        int n = ids.length;
        int token = ids[0]; // Process 0 starts election with its ID

        System.out.println("Process 0 starts election with token: " + token);

        for (int i = 1; i < n; i++) {
            System.out.println("Token (" + token + ") sent from Process " + (i - 1) + " to Process " + i);

            if (ids[i] > token) {
                System.out.println("Process " + i + " replaces token with its ID: " + ids[i]);
                token = ids[i];
            } else {
                System.out.println("Process " + i + " forwards token: " + token);
            }
        }

        // Last process sends back to Process 0
        System.out.println("Token (" + token + ") sent from Process " + (n - 1) + " to Process 0");

        if (ids[0] > token) {
            System.out.println("Process 0 replaces token with its ID: " + ids[0]);
            token = ids[0];
        } else {
            System.out.println("Process 0 recognizes leader as: " + token);
        }

        System.out.println("\nLeader elected is Process with ID: " + token);
    }
}
