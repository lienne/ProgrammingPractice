/*
Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse
the first k characters and leave the other as original.
*/


public class ReverseString2 {

    public static String reverseStr(String s, int k) {

        // Couple different approaches:
        // StringBuilder & modify in place
        // Empty StringBuilder & just copy characters over to it
        // Transform to char array, modify in place
        // Empty char array, copy chars over

        int len = s.length();

        if(len < 2) return s;

        // Copy string over to a character array so you can modify in place
        // (strings in java are immutable)
        char [] charArray = s.toCharArray();

        // Outer for loop: Traverse array in blocks of 2k
        for(int i = 0; i < len; i = i + 2*k) {
            // System.out.println("Pass # " + i/(2*k));

            int front = i;
            int end = Math.min(i+k-1, len-1);

            // Inner for loop: traverse half of each block individually, using i as 1st pointer coming from the front, j as 2nd pointer coming from the end
            for(int j = end; j > front; j--) {
                // Swap chars within first half of block
                char temp = charArray[front];
                charArray[front] = charArray[j];
                charArray[j] = temp;
                front++;
            }
        }

        return new String(charArray);


        // StringBuilder method
        // StringBuilder sb = new StringBuilder(s);
        // int len = s.length();

        // for(int i = 0; i < len; i += 2*k) {
        //     int front = i;
        //     int j = i + k - 1;
        //     if(j >= len) j = len-1;

        //     for(int end = j; end > front; end--) {
        //         char temp = sb.charAt(front);
        //         sb.setCharAt(front,  sb.charAt(end));
        //         sb.setCharAt(end, temp);
        //         front++;
        //     }
        // }

        // return sb.toString();
    }

    public static void main(String [] args) {
        String result1 = reverseStr("abcdefg", 2);
        System.out.println("Result 1 should be \"bacdfeg\", is: " + result1);

        String result2 = reverseStr("a", 2);
        System.out.println("Result 2 should be \"a\", is: " + result2);

        String result3 = reverseStr("123456", 4);
        System.out.println("Result 3 should be \"432156\", is: " + result3);

        String result4 = reverseStr("abcdef", 4);
        System.out.println("Result 4 should be \"dcbaef\", is: " + result4);

        String result5 = reverseStr("", 0);
        System.out.println("Result 5 should be \"\", is: " + result5);

        String result6 = reverseStr("abcdefghij", 4);
        System.out.println("Result 6 should be \"dcbaefghji\", is: " + result6);

        String result7 = reverseStr("abcdefghijklmnopqrs", 4);
        System.out.println("Result 7 should be \"dcbaefghlkjimnopsrq\", is: " + result7);
    }
}