import java.util.*;
public class Strings {
     // public static void printletters(String str) {
    //         for(int i = 0; i <str.length(); i++) {
    //             System.out.print(str.charAt(i) + " ");
    //         }
    //         System.out.println();
    //     }
        // public static boolean ispalindrome(String str) {
        //     for(int i = 0 ; i < str.length()/2; i++) {
        //         int n = str.length();
        //         if(str.charAt(i) != str.charAt(n-1-i)) {
        //             // not palindrome
        //             return false;
        //         }
        //     }
        //     return true;
        // }
        // public static float getshortestpath(String path) {
        //     int x = 0 , y = 0;
        //     for(int i = 0; i < path.length() ; i++) {
        //         char dir = path.charAt(i);
        //         // north
        //         if(dir == 'S') {
        //             y--;
        //         }
        //         //  north
        //         else if(dir == 'N') {
        //             y++;
        //         }
        //         // east
        //         else if(dir == 'E') {
        //             x--;
        //         }
        //         else {
        //             x++;
        //         }
        //     }
        //     int X2 = x*x;
        //     int Y2 = y*y;
        //     return(float)(Math.sqrt(X2 + Y2));
        // }
        // public static String subString(String str, int si , int ei) {
        //     String substr = "";
        //     for(int i = si ; i< ei ; i++) {
        //         substr += str.charAt(i);
        //     }
        //     return substr;
        // }
        // public static String toUpperCase(String str) {
        //     StringBuilder sb = new StringBuilder("");
        //     char ch = Character.toUpperCase(str.charAt(0));
        //     sb.append(ch);

        //     for(int i = 1 ; i < str.length(); i++) {
        //         if(str.charAt(i) == ' ' && i < str.length()-1) {
        //             sb.append(str.charAt(i));
        //             i++;
        //             sb.append(Character.toUpperCase(str.charAt(i)));
        //         } else {
        //             sb.append(str.charAt(i));
        //         }
        //     }
        //     return sb.toString();
        // }
   
        // public static String compression(String str) {
        //     String newstr = "";
        //     for(int i = 0 ; i < str.length()-1 ; i++) {
        //         Integer count = 1;
        //         while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
        //             count++;
        //             i++;
        //         }
        //         newstr += str.charAt(i);
        //         if(count > 1) {
        //             newstr += count.toString();
        //         }

        //     }
        //     return newstr;
        // }

    //    public static String anagrams(String str,String str2) {
    //     for(int i = 0 ; i < str.length(); i++) {
    //         for(int j = 0 ; j <str.length(); j++) {
    //         if(str.charAt(i) == str2.charAt(j));
    //         System.out.println('anagrams');
    //     }
    //     }
    //    }
    public static void main(String args[]) {
      System.out.println((5&6));
    }
}



       