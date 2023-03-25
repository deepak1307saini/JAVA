package Pattern;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j <i+1; j++) {
                System.out.print(i+1+" ");
            }
            System.out.println();
        }
    }
}

//5
//            1
//           2 2
//          3 3 3
//         4 4 4 4
//        5 5 5 5 5
