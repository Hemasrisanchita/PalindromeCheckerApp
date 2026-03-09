// PalindromeCheckerApp.java

import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Append character to linked list
    void append(char c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Get the middle node using fast and slow pointer
    Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Reverse a linked list starting from given node
    Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Check if linked list is palindrome
    boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;

        Node middle = getMiddle(head);
        Node secondHalfStart = reverse(middle.next);

        Node firstHalf = head;
        Node secondHalf = secondHalfStart;
        boolean palindrome = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                palindrome = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Restore the original list (optional)
        middle.next = reverse(secondHalfStart);

        return palindrome;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        // Normalize input: remove spaces, punctuation, convert to lowercase
        input = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        LinkedList list = new LinkedList();
        for (char c : input.toCharArray()) {
            list.append(c);
        }

        if (list.isPalindrome()) {
            System.out.println("The string is a palindrome!");
        } else {
            System.out.println("The string is NOT a palindrome!");
        }

        scanner.close();
    }
}