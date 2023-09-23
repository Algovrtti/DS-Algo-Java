import java.util.*;
public class Classroom{
    // public static boolean pairsum1( ArrayList<Integer> List , int target ){
    //     for(int i = 0 ; i < List.size(); i++){
    //         for(int j = i+1 ; j  < List.size(); j++){
    //             if(List.get(i) + List.get(j) == target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
    public static boolean pairsum1( ArrayList<Integer> List , int target ){
        int lp = 0;
        int rp = List.size()-1;

        while (lp != rp){
            //  case 1
            if(List.get(lp) + List.get(rp) == target){
                return true;
            }
            // case 2
            if(List.get(lp) + List.get(rp) < target){
                lp++;
            } else{
                // case 3
                rp--;
            }
        }
        return false;
    }
    public static boolean pairsum2( ArrayList<Integer> List , int target ){
        int bp = -1;
        int n = List.size();
        for(int i = 0; i < List.size();i++) {
            if(List.get(i) > List.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1; //smallest
        int rp = bp; //largest

        while(lp != rp){
            // case 1
            if(List.get(lp) + List.get(rp) == target){
                return true;
            }
            if(List.get(lp) + List.get(rp) < target){
                lp = (lp+1) % n;
            } else{
                rp = (n+rp-1) % n;
            }
        }
        return false;
    }
    public static void main(String args[]){
        ArrayList<Integer> List = new ArrayList<>();
        // 1,8,6,2,5,4,8,3,7
        List.add(11);
        List.add(15);
        List.add(6);
        List.add(8);
        List.add(9);
        List.add(10);
        int target = 19;
        System.out.println(pairsum2(List , target));

        }
} 
