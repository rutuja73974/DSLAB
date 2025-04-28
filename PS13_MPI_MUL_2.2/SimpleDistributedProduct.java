import mpi.*;

public class SimpleDistributedProduct {
    public static void main(String[] args) {
        MPI.Init(args);

        int rank = MPI.COMM_WORLD.Rank();
        int size = MPI.COMM_WORLD.Size();
        int unitSize = 5;
        int[] sendBuffer = new int[unitSize * size];
        int[] recvBuffer = new int[unitSize];

        if (rank == 0) {
            for (int i = 0; i < unitSize * size; i++) {
                sendBuffer[i] = i + 1;
            }
        }

        MPI.COMM_WORLD.Scatter(sendBuffer, 0, unitSize, MPI.INT,
                               recvBuffer, 0, unitSize, MPI.INT, 0);

        long localProduct = 1;
        for (int num : recvBuffer) {
            localProduct *= num;
        }

        System.out.println("Process " + rank + " local product: " + localProduct);

        int[] gatherBuffer = new int[size];
        MPI.COMM_WORLD.Gather(
            new int[] { (int)localProduct }, 0, 1, MPI.INT,
            gatherBuffer, 0, 1, MPI.INT, 0
        );

        if (rank == 0) {
            long finalProduct = 1;
            for (int val : gatherBuffer) {
                finalProduct *= val;
            }
            System.out.println("Final product: " + finalProduct);
        }

        MPI.Finalize();
    }
}

//Steps to run this program 
/*
 * 1) Unzip the "mpjexpress" into the "C drive" of the machine such that "C:\mpjexpress"
 * 2) Steps to run the code 
 *      2.1) Set Environment Variables (Temporary, in your Command Prompt of the system not in VScode)
 *          set MPJ_HOME=C:\mpjexpress
            set PATH=%PATH%;%MPJ_HOME%\bin
        2.2) Compile your code with MPJ library
            javac -cp .;%MPJ_HOME%\lib\mpj.jar SimpleDistributedProduct.java
        2.3) Run using mpjrun
            mpjrun.bat -np 4 SimpleDistributedProduct
            Here 4 means 4 process 
 */
