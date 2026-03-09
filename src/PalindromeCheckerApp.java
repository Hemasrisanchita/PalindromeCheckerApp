// PalindromeCheckerApp.java

import java.util.Scanner;

public class PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int start, int end) {
        // Base condition: crossed pointers or single character
        if (start >= end) {
            return true;
        }
        // If characters at current pointers don't match, not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        // Recur for inner substring
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize input: remove non-alphanumeric characters and convert to lowercase
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome!");
        }

        scanner.close();
    }
}