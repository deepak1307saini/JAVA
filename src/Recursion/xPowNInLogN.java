package Recursion;
import java.util.*;


public class xPowNInLogN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x=sc.nextInt();
        int n=sc.nextInt();

        System.out.println(power(x,n));

    }

    private static int power(int x, int n) {
        if (n==0) return 1;
        if (n==1) return x;

        int result=power(x,n/2);
        if (n%2==0){
            return result*result;
        }
        return x*result*result;
    }
}
