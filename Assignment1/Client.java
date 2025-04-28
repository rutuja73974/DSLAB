import java.rmi.*;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            String url = "rmi://localhost/Server";

            ServerIntf serverIntf = (ServerIntf) Naming.lookup(url);

            System.out.println("Enter num1:");
            int a = sc.nextInt();

            System.out.println("Enter num2:");
            int b = sc.nextInt();

            sc.nextLine(); // Consume the newline left by nextInt()

            System.out.println("Enter str1:");
            String str1 = sc.nextLine();

            System.out.println("Enter str2:");
            String str2 = sc.nextLine();

            System.out.println("Add is: " + serverIntf.addition(a, b));
            System.out.println("Sub is: " + serverIntf.substraction(a, b));
            System.out.println("Mul is: " + serverIntf.multiplication(a, b));
            System.out.println("Div is: " + serverIntf.division(a, b));
            System.out.println("Square is: " + serverIntf.square(a));
            System.out.println("Square root is: " + serverIntf.squareroot(b));

            System.out.println("Palindrome of string: " + serverIntf.palindrome(str1)); // Display the result of
                                                                                        // palindrome check
            System.out.println("String is equal or not: " + serverIntf.isequalstring(str1, str2)); // Display result of
                                                                                                   // string comparison

            // New Conversion Operations
            System.out.println("Enter temperature in Celsius:");
            double celsius = sc.nextDouble();
            System.out.println("Celsius to Fahrenheit: " + serverIntf.celsiusToFahrenheit(celsius));

            System.out.println("Enter distance in miles:");
            double miles = sc.nextDouble();
            System.out.println("Miles to Kilometer: " + serverIntf.milesToKilometer(miles));

            // ✅ Newly Added Operations
            sc.nextLine(); // Consume newline after nextDouble()

            System.out.println("Enter a string to count vowels:");
            String vowelStr = sc.nextLine();
            System.out.println("Number of vowels: " + serverIntf.countVowels(vowelStr));

            System.out.println("Enter a number to find factorial:");
            int num = sc.nextInt();
            System.out.println("Factorial is: " + serverIntf.factorial(num));

            sc.nextLine(); // Consume newline

            System.out.println("Enter first string for comparison:");
            String compareStr1 = sc.nextLine();

            System.out.println("Enter second string for comparison:");
            String compareStr2 = sc.nextLine();

            System.out.println("Comparison result: " + serverIntf.compareStrings(compareStr1, compareStr2));

            System.out.println("Lexicographically largest string: "
                    + serverIntf.lexicographicallyLargest(compareStr1, compareStr2));

        } catch (Exception e) {
            System.out.println("Exception at Client: " + e);
        }
        sc.close();
    }
}
