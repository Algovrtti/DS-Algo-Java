import java.util.*;
public class maxmindst{
    static int tree[];

    public static void init(int n){
          tree = new int[4*n];
    }

    public static void buildtree(int i, int si ,int sj, int arr[]){
        if(si == sj){
            tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        buildtree( 2*i+1, si, mid,arr); 
        buildtree( 2*i+2, mid+1,sj,arr); 

         tree[i] = Math.max(tree[2*i+1] , tree[2*i+2]);
    } 
    public static int getmax(int arr[] , int qi , int qj){
        int n = arr.length;
        return getmaxUtil(0,0,n-1,qi,qj); 
    }
    public static int getmaxUtil(int i , int si , int sj ,int qi ,int qj){
          if(si > qj || sj < qi){ // no overlap
            return Integer.MIN_VALUE;
        } else if(si >= qi && sj <= qj){ // complete overlap
            return tree[i];
        } else{
            int mid = (si+sj)/2;
            int leftans = getmaxUtil(2*i+1, si, mid, qi, qj);
            int rightans = getmaxUtil(2*i+2, mid+1,sj, qi, qj);
            return Math.max(leftans, rightans);
    }
    }
    public static void update(int arr[] , int idx, int newval){
        arr[idx] = newval;
        int n = arr.length;
        updateUtil(0,0,n-1,idx,newval);
    }
    public static void updateUtil(int i , int si, int sj, int idx, int newval){
        if(idx < si || idx > sj){
            return;
        }
        tree[i] = Math.max(tree[i] , newval);
          int mid = (si+sj)/2;
             updateUtil(2*i+1, si, mid, idx, newval);
             updateUtil(2*i+2, mid+1,sj, idx, newval);
    }
    public static void main(String args[]){
        int arr[] = {6,8,-1,2,17,1,3,2,4};
        int n = arr.length;
        init(n);
        buildtree(0,0,n-1,arr);

        // for(int i = 0; i < tree.length; i++){
        //     System.out.print(tree[i] + " ");
    // }
            int max = getmax(arr, 2,5);
             System.out.println(max); // 17

             update(arr, 2 , 20);

              max = getmax(arr, 2, 5);
             System.out.println(max);
        
    
    }
}
