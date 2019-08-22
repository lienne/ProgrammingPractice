public class ReverseWords {

    public static String reverseWords(String s) {
        String [] words = s.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < words.length; i++) {
            System.out.println(i + ": " + "\"" + words[i] + "\"");
        }
        
        for(int i = words.length - 1; i >= 0; i--) {
            if(words[i].length() > 0) {
                result.append(words[i]).append(" ");
            }
        }
        
        return result.toString().trim();
    }

    public static void main(String [] args) {

        String test1 = "the sky is blue";
        String test2 = "  hello world!  ";

        String result1 = reverseWords(test1);
        // System.out.println("\"" + result1 + "\"");

        String result2 = reverseWords(test2);
        // System.out.println("\"" + result2 + "\"");
    }
}