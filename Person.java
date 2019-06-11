import java.util.*;

public class Person {
  private int age;

  // constructor
  public Person(int initialAge) {
      if(initialAge > 0) {
        this.age = initialAge;
        //age = initialAge;
      }
      else {
        age = 0;
        // this.age = 0;
      }
  }

  public void amIOld() {
    if(age < 13)
      System.out.println("You are young.");
    if(age >= 13 && age <= 18)
      System.out.println("You are a teenager.");
    else if(age >= 18)
      System.out.println("You are old.");
  }

  public void yearPasses() {
    age++;
  }

  public static void main(String [] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt(); // # of test cases

    for(int i = 0; i < T; i++) {
      int age = in.nextInt();
      Person p = new Person(age);
      p.amIOld();
    }

    in.close();
  }

}
