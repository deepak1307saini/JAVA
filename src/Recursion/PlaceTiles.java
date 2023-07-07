package Recursion;

import java.util.Scanner;

public class PlaceTiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int m= sc.nextInt();

        System.out.println(countWays(n,m));
    }

    private static int countWays(int n,int m){
        if (n==m) return 2;
        if (n<m) return 1;

        return countWays(n-m,m)+countWays(n-1,m);
    }

//    private static int countWays(int i,int n,int m){
//        if (i==n) return 1;
//        if (i>n) return 0;
//
//        return countWays(i+1,n,m)+countWays(i+m,n,m);
//    }
}
