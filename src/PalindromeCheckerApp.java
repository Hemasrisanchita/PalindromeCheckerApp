public class PalindromeCheckerApp {

    public static void main(String[] args) {
        String word = "racecar";
        String reversed = "";

        // Reverse string manually
        for(int i = word.length() - 1; i >= 0; i--){
            reversed += word.charAt(i);
        }

        // Compare
        if(word.equals(reversed)){
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }
}