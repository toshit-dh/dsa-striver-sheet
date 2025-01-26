package Strings;

public class FirstOccurence {
    public static int strStr(String haystack, String needle) {
        int nL = needle.length();
        int hL = haystack.length();
        for (int i = 0; i <= hL-nL; i++) {
            if (haystack.substring(i,i+nL).equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(strStr("a","a"));
    }
}
