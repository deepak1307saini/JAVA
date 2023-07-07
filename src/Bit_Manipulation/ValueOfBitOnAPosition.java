package Bit_Manipulation;

public class ValueOfBitOnAPosition {
    public static void main(String[] args) {
        int a = 5; //0101
        int pos = 3;
        int bitMask = 1 << pos;

        if ((bitMask & a) == 0) {
            System.out.println("Bit was zero");
        } else {
            System.out.println("Bit was one");
        }
    }
}
