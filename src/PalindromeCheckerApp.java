public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Hardcoded string
        String word = "madam";

        // Check palindrome
        if(word.equals(new StringBuilder(word).reverse().toString())){
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}