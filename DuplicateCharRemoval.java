// Remove all duplicate characters from a given String.
// Ex.: "aaabacc" should return "abc".

import java.util.*; // Contains HashMap, HashSet, Scanner

public class DuplicateCharRemoval {
  static String duplicateRemoval(String s) {
    // Plan of attack:
    // Get each char from the string, store it in a HashMap
    // Key = character of string, Value = index
    // HashMap allows duplicate values, but not duplicate keys
    // Use that to your advantage to remove duplicate characters

    HashMap<Character, Integer> myHash = new HashMap<>();
    StringBuilder newString = new StringBuilder();

    // HashMap does not allow duplicate *keys*, so make chars the keys
    // This way, chars only get added if they aren't already mapped to an index
    for(int i = 0; i < s.length(); i++) {
      myHash.put(s.charAt(i), i);
    }

    int index = 0;
    for(Character key : myHash.keySet()) {
      // System.out.print(key);
      newString.insert(index, key);
      index++;
    }

    return newString.toString();
  }

  public static void main(String [] args) {
    String myString1 = "aaabacc";
    String myString2 = "aaabcc";
    String myString3 = "a";
    // String myString4 = "\xff\x25\x00\x41";

    System.out.println(duplicateRemoval(myString1));
    System.out.println(duplicateRemoval(myString2));
    System.out.println(duplicateRemoval(myString3));
    //System.out.println(duplicateRemoval(myString4));
  }

}
