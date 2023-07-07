package Recursion;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.Scanner;

public class SubSetOfNNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n=sc.nextInt();

        ArrayList<Integer> subset=new ArrayList<>();

        findSubsets(n,subset);
    }

    private static void findSubsets(int n, ArrayList<Integer> subset) {
        if (n==0){
            printSubset(subset);
            return;
        }

        subset.add(n);
        findSubsets(n-1,subset);
        subset.remove(subset.size()-1);
        findSubsets(n-1,subset);
    }

    private static void printSubset(ArrayList<Integer> subset) {
        int n=subset.size();
        for (int i = 0; i<n; i++) {
            System.out.print(subset.get(i));
        }
        System.out.println();
    }
}
