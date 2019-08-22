public class ValidNumber {
	public static void main(String [] args) {
		String s1 = "0";
		String s2 = "100.3";
		String s3 = "2e10";
		String s4 = "abc";

		float f1 = isNumber(s1);
		System.out.println("s1: " + f1);

		float f2 = Float.parseFloat(s2);
		System.out.println("s2: " + f2);

		float f3 = Float.parseFloat(s3);
		System.out.println("s3: " + f3);

		float f4 = Float.parseFloat(s4);
		System.out.println("s4: " + f4);
	}

	public boolean isNumber(String s) {
        
        if(Character.isLetter(s.charAt(s.length()-1))) return false;
        
        try {
            float f = Float.parseFloat(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}