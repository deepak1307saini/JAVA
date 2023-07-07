package Recursion;
import java.util.*;

public class UniqueSubSequences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        HashSet<String> st = new HashSet<>();
        subSequences(0,str,"",st);
    }

    private static void subSequences(int idx, String str, String newString, HashSet<String> st) {
        if(idx==str.length()) {
            if (st.contains(newString)) return;
            st.add(newString);
            System.out.println(newString);
            return;
        }

        char currentChar = str.charAt(idx);
        subSequences(idx+1,str,(newString+currentChar), st);
        subSequences(idx+1,str,newString, st);
    }
}
