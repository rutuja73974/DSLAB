import java.util.*;

public class BullyAlgorithm {
    static class Process {
        int id;
        boolean active;

        Process(int id) {
            this.id = id;
            this.active = true;
        }

        void deactivate() {
            active = false;
        }
    }

    static List<Process> processes = new ArrayList<>();
    static int coordinatorId = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.println("Enter process IDs:");
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            processes.add(new Process(id));
        }

        processes.sort(Comparator.comparingInt(p -> p.id));

        coordinatorId = processes.get(n - 1).id;
        System.out.println("Initially, Process " + coordinatorId + " is the coordinator.");

        System.out.print("\nEnter the process ID that detects coordinator failure: ");
        int initiatorId = sc.nextInt();

        electLeader(initiatorId);
        sc.close();
    }

    static void electLeader(int initiatorId) {
        Process initiator = findProcessById(initiatorId);

        if (initiator == null || !initiator.active) {
            System.out.println("Initiator process not found or inactive.");
            return;
        }

        System.out.println("\nProcess " + initiator.id + " initiates election.");

        boolean higherActiveFound = false;

        for (Process p : processes) {
            if (p.id > initiator.id && p.active) {
                System.out.println("Process " + initiator.id + " sends Election message to Process " + p.id);
                higherActiveFound = true;
            }
        }

        if (!higherActiveFound) {
            System.out.println("No higher active process found. Process " + initiator.id + " becomes coordinator.");
            coordinatorId = initiator.id;
            announceCoordinator();
        } else {
            for (Process p : processes) {
                if (p.id > initiator.id && p.active) {
                    respondElection(p);
                    break; // Only first higher process continues
                }
            }
        }
    }

    static void respondElection(Process responder) {
        System.out.println("Process " + responder.id + " responds to election.");

        boolean higherActiveFound = false;

        for (Process p : processes) {
            if (p.id > responder.id && p.active) {
                System.out.println("Process " + responder.id + " sends Election message to Process " + p.id);
                higherActiveFound = true;
            }
        }

        if (!higherActiveFound) {
            System.out.println("No higher active process found. Process " + responder.id + " becomes coordinator.");
            coordinatorId = responder.id;
            announceCoordinator();
        } else {
            for (Process p : processes) {
                if (p.id > responder.id && p.active) {
                    respondElection(p);
                    break;
                }
            }
        }
    }

    static void announceCoordinator() {
        for (Process p : processes) {
            if (p.active && p.id != coordinatorId) {
                System.out.println("Coordinator message sent to Process " + p.id + " by Process " + coordinatorId);
            }
        }
        System.out.println("\nProcess " + coordinatorId + " is now the Coordinator.");
    }

    static Process findProcessById(int id) {
        for (Process p : processes) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }
}

/*/
Enter number of processes: 5
Enter process IDs:
10 23 1
34
4
Initially, Process 34 is the coordinator.

Enter the process ID that detects coordinator failure: 1

Process 1 initiates election.
Process 1 sends Election message to Process 4
Process 1 sends Election message to Process 10
Process 1 sends Election message to Process 23
Process 1 sends Election message to Process 34
Process 4 responds to election.
Process 4 sends Election message to Process 10
Process 4 sends Election message to Process 23
Process 4 sends Election message to Process 34
Process 10 responds to election.
Process 10 sends Election message to Process 23
Process 10 sends Election message to Process 34
Process 23 responds to election.
Process 23 sends Election message to Process 34
Process 34 responds to election.
No higher active process found. Process 34 becomes coordinator.
Coordinator message sent to Process 1 by Process 34
Coordinator message sent to Process 4 by Process 34
Coordinator message sent to Process 10 by Process 34
Coordinator message sent to Process 23 by Process 34

Process 34 is now the Coordinator.
*/
