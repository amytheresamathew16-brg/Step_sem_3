package com.sem3step;

import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative Approach (Two-pointer technique)
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

    // 2. Recursive Approach
    public static boolean isPalindromeRecursive(String text) {
        text = text.toLowerCase();
        // Base case: empty or 1-character string is always a palindrome
        if (text.length() <= 1) {
            return true;
        }
        // If first and last characters don't match
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        // Recursive call with substring excluding first and last characters
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    // 3. Array Reversal Approach
    public static boolean isPalindromeArrayReversal(String text) {
        text = text.toLowerCase();
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[originalArray.length];

        // Fill reversedArray backward
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        // Compare original and reversed character arrays
        String reversedText = new String(reversedArray);
        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== QA Text Verification Toolkit: Palindrome Checker ===");
        System.out.print("Enter text to check: ");
        String text = scanner.nextLine().trim();

        // Run all three checks
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayReversalResult = isPalindromeArrayReversal(text);

        // Format output labels
        String iterStr = iterativeResult ? "Palindrome" : "Not Palindrome";
        String recurStr = recursiveResult ? "Palindrome" : "Not Palindrome";
        String arrayStr = arrayReversalResult ? "Palindrome" : "Not Palindrome";

        // Display results side-by-side
        System.out.printf("Iterative: %s | Recursive: %s | Array Reversal: %s\n",
                iterStr, recurStr, arrayStr);

        scanner.close();
    }
}