package Recursion;

import java.util.Arrays;
import java.util.Scanner;

//Complexity n!
public class AllPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char[] charArray =str.toCharArray();
        Arrays.sort(charArray);
        str=new String(charArray);
        printPermutation(str,0,str.length());

//        printPermutation(str, "");
    }

//    private static void printPermutation(String str, String permutation) {
//        if (str.length() == 0) {
//            System.out.println(permutation);
//            return;
//        }
//
//        for (int i = 0; i < str.length(); i++) {
//            char currentChar = str.charAt(i);
//            printPermutation(str.substring(0, i) + str.substring(i + 1), permutation + currentChar);
//        }
//    }

    private static void printPermutation(String str, int l, int n) {
        if (l >= n) {
            System.out.println(str);
            return;
        }

        for (int i = l; i <n; i++) {
            str=swap(str, l, i);
            printPermutation(str,l+1,n);
            str=swap(str,l,i);
        }
    }

    private static String swap(String str, int i, int j) {
        if (j==i) return str;
        if (j>=str.length()-1)
            return str.substring(0, i) + str.charAt(j)
                    + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j)
                + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1);
    }
}
