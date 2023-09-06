public class palindrome{
public static boolean isPalindrome(String str) {
        
        str = str.replaceAll("\\s+", "").toLowerCase();

     
        String reversedStr = new StringBuilder(str).reverse().toString();

        return str.equals(reversedStr);
        //gsgs
    }

     public static void main(String[] args) {
        String input = "racecar"; 

        if (palindrome.isPalindrome(input)) {
            System.out.println("The entered string is a palindrome.");
        } else {
            System.out.println("The entered string is not a palindrome.");
        }
    }
}