import java.util.*;

public class dice_roll_main {

  public static void rollDice() {

    Scanner scan = new Scanner(System.in);
    DiceRoll die = new DiceRoll();
    String user_input;

    System.out.println("Type: \"Roll\"  " + "to roll or \"Exit\" to exit");
    user_input = scan.next();

    while(!user_input.equalsIgnoreCase("exit")) {

      if(user_input.equalsIgnoreCase("roll")) {
        System.out.println(die.roll());
        rollDice();
      }
      else {
        System.out.println("Invalid, try again!");
        System.out.println(user_input);
        rollDice();
      }

      System.exit(1);
    }

    scan.close();

  }

   public static void main(String[] agrs) {

        rollDice();

   }
}

class DiceRoll {

    private int rolled_number;

    public DiceRoll() {
        roll();
    }

    public int roll() {
        Random ran = new Random();
        rolled_number = ran.nextInt(6) + 1;
        return rolled_number;
    }
}
