package Greedy;

public class ParenthesisChecker {
    public static boolean checkValidString(String s) {
        return greedyApproach(s);
    }
    public static boolean recursiveApproach(String s,int index,int count,int length){
        if (count < 0) return false;
        if (index == length) return count == 0;
        if (s.charAt(index) == '(') return recursiveApproach(s,index+1,count+1,length);
        if (s.charAt(index) == ')') return recursiveApproach(s,index+1,count-1,length);
        else {
            return recursiveApproach(s,index+1,count+1,length)
                    || recursiveApproach(s,index+1,count-1,length)
                    || recursiveApproach(s,index+1,count,length);
        }
    }
    public static boolean greedyApproach(String s){
        int min = 0,max = 0,n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '('){
                min++;
                max++;
            }
            else if (s.charAt(i) == ')'){
                min--;
                max--;
            }else {
                min--;
                max++;
            }
            if (min < 0) min = 0;
            if (max < 0) return false;
        }
        return min == 0;
    }
    public static void main(String[] args) {
        System.out.println(checkValidString(
                "((*))")
        );
    }
}
