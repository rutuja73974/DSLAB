import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    public ServerImpl() throws RemoteException {
        super(); // Ensure the remote object is exported
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int substraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int division(int a, int b) throws RemoteException {
        return a / b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public int square(int a) throws RemoteException {
        return a * a;
    }

    public double squareroot(int a) throws RemoteException {
        return Math.sqrt(a);
    }

    public String palindrome(String str) throws RemoteException {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        if (str.equals(sb.toString())) {
            return "String is Palindrome!";
        } else {
            return "String is Not Palindrome!";
        }
    }

    public String isequalstring(String str1, String str2) throws RemoteException {
        if (str1.equals(str2)) {
            return "String is equal!";
        } else {
            return "String is not equal!";
        }
    }

    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9.0 / 5.0) + 32;
    }

    public double milesToKilometer(double miles) throws RemoteException {
        return miles * 1.60934;
    }

    // ✅ NEW: Count vowels in a string
    public int countVowels(String str) throws RemoteException {
        int count = 0;
        str = str.toLowerCase();
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    // ✅ NEW: Find factorial of a number
    public int factorial(int n) throws RemoteException {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // ✅ NEW: Compare two strings lexicographically
    public String compareStrings(String str1, String str2) throws RemoteException {
        if (str1.equals(str2)) {
            return "Both strings are equal.";
        } else if (str1.compareTo(str2) > 0) {
            return "First string is lexicographically greater.";
        } else {
            return "Second string is lexicographically greater.";
        }
    }

    // ✅ NEW: Return lexicographically larger string
    public String lexicographicallyLargest(String str1, String str2) throws RemoteException {
        if (str1.compareTo(str2) > 0) {
            return str1;
        } else {
            return str2;
        }
    }
}
