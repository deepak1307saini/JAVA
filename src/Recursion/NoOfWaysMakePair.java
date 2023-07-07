package Recursion;

import java.util.Scanner;

//Find the number of ways in which you can invite n people  to your party, single or in pairs
public class NoOfWaysMakePair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(callParty(n));
    }

    private static int callParty(int n) {
        if(n<=1) return 1;

        return (n-1)*callParty(n-2) + callParty(n-1);
    }
}