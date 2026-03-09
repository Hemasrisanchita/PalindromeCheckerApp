// PalindromeCheckerApp.java

import java.util.Scanner;

class PalindromeChecker {
    // Public method to check palindrome
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Normalize input: remove spaces and non-alphanumeric characters, convert to lowercase
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Use internal method to check palindrome
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    // Private helper: recursive palindrome logic
    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;                // Base condition
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(input)) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome!");
        }

        scanner.close();
    }
}