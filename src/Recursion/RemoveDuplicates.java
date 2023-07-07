package Recursion;

import java.util.Scanner;

public class RemoveDuplicates {

    public static boolean[] map = new boolean[26];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str= sc.next();
        StringBuffer newString=new StringBuffer("");
        removeDuplicates(0,str,newString);
        System.out.println(newString);
    }

    private static void removeDuplicates(int idx, String str, StringBuffer newString) {
        if (idx==str.length()){
            return;
        }

        char currentChar = str.charAt(idx);
        if (map[currentChar-'a']==true){
            removeDuplicates(idx+1,str,newString);
        }
        else {
            newString.append(currentChar);
            map[currentChar-'a']=true;
            removeDuplicates(idx+1,str,newString);
        }
    }
}
