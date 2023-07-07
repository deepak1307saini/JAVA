package Recursion;
import java.util.*;

public class AllSubSequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.next();

        subSequences(0,str,"");
    }

    private static void subSequences(int idx, String str, String newString) {
        if(idx==str.length()) {
            System.out.println(newString);
            return;
        }

        char currentChar = str.charAt(idx);
        subSequences(idx+1,str,(newString+currentChar));
        subSequences(idx+1,str,newString);
    }
}
