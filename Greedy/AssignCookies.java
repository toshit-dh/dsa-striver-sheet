package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int m = g.length;;
        int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int cookie = 0;
        int child = 0;
        while(cookie < n && child < m){
            if(g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
    }
}
