package Strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if ((mapS.containsKey(ch1) && mapS.get(ch1) != ch2) || (mapT.containsKey(ch2) && mapT.get(ch2) != ch1)) {
                return false;
            }
            mapS.put(ch1, ch2);
            mapT.put(ch2, ch1);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
