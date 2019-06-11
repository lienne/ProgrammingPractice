// <Pangram>
// alphabet set: {a, b, c} --> set = [a,b,c]
// string: baadcab
//
// shortest substr ==> cab

// Brute force: double for loop

// Try more optimized solution:
// HashMap<Integer, Character>
// where indices of the string are mapped to the keys of the hashmap
// and individual characters of the string are mapped to the values of the hashmap

int count = 0, int shortestCount = 0;

StringBuilder shortestString = new StringBuilder(s);

StringBuilder newString = new StringBuilder();

HashSet<Character> myHash = new HashSet<>();

for(int i = 0; i < set.length(); i++) {
  myHash.add(set[i]);
}


for(int i = 0; i < s.length(); i++) {
  for(int j = i+1; j < s.length(); j++) {
    if(shortestCount < count) {
      count = shortestCount;
    }

    if(newString.length() < shortestString.length()){
      shortestString.length() = newString.length();
    }

    if(myHash.contains(s.charAt(j)){
      newString.insert(s.charAt(j));
    }



  }
}
