import java.util.*;
public class Dp{
    // memoizatiom
    // public static int fib(int n ,int f[]){
    //     if(n == 0 || n == 1){
    //         return n;
    //     }
    //     if(f[n] != 0){ //fib(n) is aldready calculated
    //     return f[n];
    //     }
    //     f[n] = fib(n-1,f) + fib(n-2,f);
    //     return f[n];
    // }
    // tabulization
    // public static int fibTabulization(int n){
    //     int dp[] = new int[n+1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //     for(int i = 2; i <= n ; i++){
    //         dp[i] = dp[i-1] + dp[i-2];
    //     }
    //     return dp[n];
    // }
    public static int countways(int n, int ways[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(ways[n] != -1){ // aldready calculated
            return ways[n];
        }
         ways[n] = countways(n-1,ways) + countways(n-2,ways);
         return ways[n];
    }
    public static int countwaysTab(int n){
        int dp[] = new int[n+1];
        dp[0] = 1;

        //tabulation loop
        for(int i = 1; i <= n; i++){
            if(i == 1){
                dp[i] = dp[i-1] + 0;
            } else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];
    }
    public static int knapsack(int val[] , int wt[] , int W, int n,int dp[][]){
        if(W == 0 || n == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }

        if(wt[n-1] <= W){ // valid
        // include
        int ans1 = val[n-1] + knapsack(val, wt, W-wt[n-1] , n-1,dp);
        // exclude
        int ans2 = knapsack(val,wt,W,n-1,dp);
        dp[n][W] = Math.max(ans1 , ans2);
        return dp[n][W];
        } else{ // not valid
            dp[n][W] = knapsack(val,wt,W,n-1,dp);
            return dp[n][W];
        }
    }
   
    public static int knapsackTab(int val[] , int wt[] , int W){
        int n = val.length;
        int dp[][] = new int[n+1][W+1];
        for(int i = 0; i < dp.length; i++){ //0th col
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){ //0th row
            dp[0][j] = 0;
        }
        for(int i = 1 ; i<n+1 ; i++){
            for(int j = 1 ; j < W+1; j++){
                int v = val[i-1];//ith item val
                int w = wt[i-1]; // ith item wt
                if(w <= j){ // valid
                    int incprofit = v + dp[i-1][j-w];
                    int excprofit = dp[i-1][j];
                    dp[i][j] = Math.max(incprofit, excprofit);
                } else { // invalid
                int excprofit = dp[i-1][j];
                dp[i][j] = excprofit;
                }
            }
        }
         print(dp); 
        return dp[n][W];
    }
     public static void print(int dp[][]){
        for(int i = 0; i < dp.length ; i++){
            for(int j = 0 ; j< dp[0].length ; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int W = 7;
        int dp[][] = new int[val.length+1][W+1];
        for(int i = 0 ; i < dp.length ;i++){
            for(int j = 0; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsackTab(val,wt,W));
       
    }
}