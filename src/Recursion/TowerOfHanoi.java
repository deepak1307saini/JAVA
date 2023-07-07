package Recursion;
import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        towerOfHanoi(n,'S','H','D');
    }

    private static void towerOfHanoi(int n, char s, char h, char d) {
        if (n==0) return;

        towerOfHanoi(n-1,s,d,h);
        System.out.println(s+" -> "+d);
        towerOfHanoi(n-1,h,s,d);
    }
}
