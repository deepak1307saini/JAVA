package Recursion;
import java.util.*;

//Complexity 4^n
public class KeypadCombination {
    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vuw","yz"};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str= sc.next();


        printComb(str,0,"");
    }

    private static void printComb(String str, int idx, String combination) {
        if (idx>=str.length()){
            System.out.println(combination);
            return;
        }
        char currentChar=str.charAt(idx);
        String mapping = keypad[currentChar-'0'];

        for (int i=0;i<mapping.length();i++){
            printComb(str,idx+1,combination+mapping.charAt(i));
        }
    }
}
