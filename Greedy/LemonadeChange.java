package Greedy;

public class LemonadeChange {
    public static boolean lemonadeChange(int[] bills) {
        int five=0,ten=0;
        for(int den: bills){
            if(den==5) five++;
            else if(den==10){
                if(five==0) return false;
                else {
                    five--;
                    ten++;
                }
            }
            else{
                if (ten>0 && five>0) {
                    ten--;
                    five--;
                }
                else if(five>=3) five -= 3;
                else return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        lemonadeChange(new int[]{5,5,5,10,10});
    }
}
