package com.neeraj.itventure;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

// Reversible Numbers
/*
1_
Some positive integers n have the property that
the sum of [n + reverse(n)] consists entirely of odd digits.

For example:
When n = 36 then 36 + 63 = 99
When n = 409 then 409 + 904 = 1313

We will call such numbers reversible; so 36, 63, 409, and 904 are reversible.

2_
Leading zeros are not allowed in either n or reverse(n).
For instance:
10 + 01 is ignored and 10 is not

There are 120 reversible numbers below one-thousand.
 */
public class Main {

  public static void listReversibleNumbers(int upperLimit) {
        /*  FOR (1 -> upperLimit)
            1. Check if the current number is a valid reversible
                - TODO: Sum of even and odd numbers is an odd number, so can write off half numbers to test
         */

        ArrayList<Integer> reversibleNumbers = new ArrayList<Integer>();

        // Loop over all numbers up to the upper limit
        int reversed, combined;
        for (int i = 1; i <= upperLimit; i++) {
            if (isReversible(i)) {
                reversed = reverseNumber(i);
                combined = i + reversed;
                if (isOdd(combined)) {
                    if (checkAllDigits(combined)) {
                        reversibleNumbers.add(i);
                    }
                }
            }
        }

        System.out.println("There are " + reversibleNumbers.size() + " reversable numbers below " + upperLimit);
        System.out.println("They are " + reversibleNumbers.toString());
    }

    // Check if the number is, or produces a valid reversable number
    public static boolean isReversible(int input) {
        // Leading zero check
        if (input % 10 == 0) {
            return false;
        }
        return true;
    }

    // Check if the input is an odd number
    public static boolean isOdd(int input) {
        return (input % 2 != 0);
    }

    // Return the reversed number
    public static int reverseNumber(int input) {
        int remainder = 0;
        int reversedNumber = 0;

        while (input > 0) {
            remainder = input % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            input = input / 10;
        }
        return reversedNumber;
    }

    // Check all digits in the number are odd
    public static boolean checkAllDigits(int input) {
        int remainder = 0;

        while (input != 0) {
            remainder = (input % 10);
            if (!isOdd(remainder)) {
                return false;
            }
            input = input / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        /*
        Take any integer as an upper limit
        and return all the reversible numbers
        from 1 to the upper limit as an array.
         */

        // Read input from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter an upper limit: ");
        int upperLimit = scan.nextInt();
//        try {
//            upperLimit = scan.nextInt();
//        }
//        catch (InputMismatchException exception) {
//            System.out.println("Please enter an upper limit which is an Integer.");
//            scan.nextLine();
//        }
        scan.close();

//        int upperLimit = 1000000000;
        listReversibleNumbers(upperLimit);


    }
    
}
