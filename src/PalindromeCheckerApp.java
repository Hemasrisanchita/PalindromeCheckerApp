// PalindromeCheckerApp.java

import java.util.*;

// Strategy interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray()) stack.push(c);
        for (char c : normalized.toCharArray()) if (c != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }
}

// Recursive strategy
class RecursiveStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
        if (input == null) return false;
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalindromeRecursive(normalized, 0, normalized.length() - 1);
    }

    private boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return isPalindromeRecursive(str, start + 1, end - 1);
    }
}

// Performance comparison driver
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to test palindrome performance:");
        String input = scanner.nextLine();

        PalindromeStrategy[] strategies = {
                new StackStrategy(),
                new DequeStrategy(),
                new RecursiveStrategy()
        };

        String[] strategyNames = {"Stack Strategy", "Deque Strategy", "Recursive Strategy"};

        System.out.println("\nPerformance Results:");
        for (int i = 0; i < strategies.length; i++) {
            long startTime = System.nanoTime();
            boolean result = strategies[i].isPalindrome(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-20s : %-5s | Time = %d ns%n",
                    strategyNames[i],
                    result ? "Palindrome" : "Not Palindrome",
                    duration);
        }

        scanner.close();
    }
}
}