/*
 * 2.4 Design a distributed application using MPI for computation where root process has 
an array of elements equal to the size of processors which is divided to the worker 
processes which calculates the reciprocal and resultant array will be displayed at root. 
 */

 import mpi.*;

 public class Main {
     public static void main(String[] args) {
         MPI.Init(args);
         int r = MPI.COMM_WORLD.Rank();
         int s = MPI.COMM_WORLD.Size();
         double[] send = new double[s];
         double[] recv = new double[1];
         double[] res = new double[s];
 
         if (r == 0) {
             for (int i = 0; i < s; i++) send[i] = i + 1;
         }
 
         MPI.COMM_WORLD.Scatter(send, 0, 1, MPI.DOUBLE, recv, 0, 1, MPI.DOUBLE, 0);
 
         recv[0] = 1.0 / recv[0];
 
         MPI.COMM_WORLD.Gather(recv, 0, 1, MPI.DOUBLE, res, 0, 1, MPI.DOUBLE, 0);
 
         if (r == 0) {
             for (int i = 0; i < s; i++) System.out.println(res[i]);
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
            javac -cp .;%MPJ_HOME%\lib\mpj.jar Main.java
        2.3) Run using mpjrun
            mpjrun.bat -np 4 Main
            Here 4 means 4 process 
 */