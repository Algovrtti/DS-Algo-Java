import java.util.*;

public class BitManipulation {
    public static void oddoreven(int n ) {
        int bitmask = 1;
        if((n & bitmask) == 0) {
            // even
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }
    public static int getIthbit(int n , int i) {
        int bitmask = 1<<i;
        if((n & bitmask) == 0) {
            return 0;
        }
        else {
            return 1;
        }
    }
    public static int setIthbit(int n , int i) {
        int bitmask = 1<<i;
        return n | bitmask;
    }
    public static int clearIthbit(int n , int i) {
        int bitmask = ~(1<<i);
        return n & bitmask;
    }
    public static int updateIthbit(int n ,int i , int newbit) {
        // if(newbit == 0) {
        //     return clearIthbit(n,i);
        // } else {
        //     return setIthbit(n,i);
        // }
        n = clearIthbit(n,i);
        int bitmask = newbit <<i;
        return n | bitmask;
    }
    public static int clearIbits(int n , int i) {
        int bitmask = (~0)<<i;
        return n & bitmask;
    }
    public static int clearbitinrange(int n , int i,int j) {
        int a =((~0)<<(j+1));
        int b = (1<<i) -1;
        int bitmask = a | b;
        return n & bitmask;
    }
    public static boolean ispoweroftwo(int n) {
        return (n&(n-1)) == 0;
    }
    public static int countsetbits(int n ) {
        int count = 0;
        while(n >0) {
            if((n & 1) != 0 ) {
                count++;
            }
           n = n>>1;
        }
        return count;
    }
    public static int fastexpo(int a , int n) {
        int ans = 1;
        while(n > 0 ) {
            if((n &1) != 0) {
            ans = ans*a;
        }
        a = a * a;
        n = n>>1;
    }
    return ans;
    }
    public static void main(String args[]) {
        // int x = 3 , y = 4;
        // System.out.println("before change x :" + x + "," + "before change y :" + y);

        // x = x^y;
        // y = x^y;
        // x = x^y;
        // System.out.println("after change x :" + x + "," + "aftr change y :" + y);
        // for(char ch = 'A' ; ch <= 'z'; ch++) {
        //     System.out.println((char)(ch |' '));
        // }
//         int x = 6;
// System.out.println(x+" + "+ 1+  " is "+ -~x);
         
        
    }
}

