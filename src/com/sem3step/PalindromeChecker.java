package com.sem3step;

import java.util.Scanner;

public class PalindromeChecker {


    public static boolean isPalindromeIterative(String text) {
        text = text.toLowerCase();
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean isPalindromeRecursive(String text) {
        text = text.toLowerCase();

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }


    public static boolean isPalindromeArrayReversal(String text) {
        text = text.toLowerCase();
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[originalArray.length];


        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }


        String reversedText = new String(reversedArray);
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== QA Text Verification Toolkit: Palindrome Checker ===");
        System.out.print("Enter text to check: ");
        String text = scanner.nextLine().trim();


        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayReversalResult = isPalindromeArrayReversal(text);


        String iterStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrayStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";


        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s\n",
                iterStr, recurStr, arrayStr);

        scanner.close();
    }
}