package Bit;

public class FlipRequired {
    public static int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int flips = 0;
        while (xor != 0){
            xor = xor & (xor - 1);
            flips++;
        }
        return flips;
    }

    public static void main(String[] args) {
        System.out.println(minBitFlips(0,31));
    }
}
