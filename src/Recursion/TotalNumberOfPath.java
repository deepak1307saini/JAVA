package Recursion;

import java.util.Scanner;

public class TotalNumberOfPath {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n= sc.nextInt();
        int m=sc.nextInt();

        System.out.println(countPath(0,0,n-1,m-1));
    }

    private static int countPath(int i, int j, int n, int m) {
        if (i==n && j==m) return 1;

        int count=0;
        if (i<n)
            count+=countPath(i+1,j,n,m);
        if (j<m)
            count+=countPath(i,j+1,n,m);
        return count;
    }
}
