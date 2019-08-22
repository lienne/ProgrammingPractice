import java.util.*;
import java.lang.*;

public class TowersOfHanoi {

    static int counter = 0;

    static void towersOfHanoi(int numberOfDiscs, char from_tower, char to_tower, char helper_tower) {

        counter++;

        // Base case, 1 disc
        if(numberOfDiscs == 1) {
            System.out.println("Moved disk 1 from tower " +  from_tower + " to tower " + to_tower);
            return;
        }

        towersOfHanoi(numberOfDiscs-1, from_tower, helper_tower, to_tower);
        System.out.println("Moved disk " + numberOfDiscs + " from tower " +  from_tower + " to tower " + to_tower);
        towersOfHanoi(numberOfDiscs-1, helper_tower, to_tower, from_tower);
    }

    public static void main(String [] args) {
        int n = Integer.parseInt(args[0]);
        towersOfHanoi(n, 'A', 'C', 'B');

        System.out.println("It took " + counter + " moves to move all discs to a new tower.");
    }
}