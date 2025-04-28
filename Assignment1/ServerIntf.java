import java.rmi.*;

interface ServerIntf extends Remote {

    public int addition(int a, int b) throws RemoteException;

    public int substraction(int a, int b) throws RemoteException;

    public int division(int a, int b) throws RemoteException;

    public int multiplication(int a, int b) throws RemoteException;

    public int square(int a) throws RemoteException;

    public double squareroot(int a) throws RemoteException;

    public String palindrome(String str) throws RemoteException; // Return a String

    public String isequalstring(String str1, String str2) throws RemoteException; // Return a String

    // New Conversion Methods
    public double celsiusToFahrenheit(double celsius) throws RemoteException;

    public double milesToKilometer(double miles) throws RemoteException;

    int countVowels(String str) throws RemoteException;

    int factorial(int n) throws RemoteException;

    String compareStrings(String str1, String str2) throws RemoteException;

    String lexicographicallyLargest(String str1, String str2) throws RemoteException;
}
