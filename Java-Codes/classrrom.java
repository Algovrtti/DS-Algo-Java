import java.util.*;

public class classrrom{
    // static class Edge implements Comparable<Edge>{
    //     int dest;
    //     int cost;

    //     public Edge(int d, int c){
    //         this.dest = d;
    //         this.cost = c;
    //     }

    //     @Override
    //     public int compareTo(Edge e2){
    //         return this.cost - e2.cost; //ascending
    //     }
    // }

    // public static int connectCities(int cities[][]){
    //     PriorityQueue<Edge> pq = new PriorityQueue<>();
    //     boolean vis[] = new boolean[cities.length];

    //     pq.add(new Edge(0,0));
    //     int finalcost = 0;

    //     while(!pq.isEmpty()){
    //         Edge curr = pq.remove();
    //         if(!vis[curr.dest]){
    //             vis[curr.dest] = true;
    //             finalcost += curr.cost;

    //             for(int i = 0; i <cities[curr.dest].length; i++){
    //                 if(cities[curr.dest][i] != 0){
    //                     pq.add(new Edge(i, cities[curr.dest][i]));
    //                 }
    //             }
    //         }
    //     }
    //     return finalcost;
    // }
    // public static void main(String args[]){
    //     int cities[][] = {{0,1,2,3,4},
    //                       {1,0,5,0,7},
    //                       {2,5,0,6,0},
    //                       {3,0,6,0,0},
    //                       {4,7,0,0,0}};
    //     System.out.println(connectCities(cities));
    // }
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i = 0; i <n; i++){
            par[i] = i;
        }
    }
    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] =find(par[x]);
    }
    public static void union(int a,int b){
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]){
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] < rank[parB]){
        par[parA] = parB;
        } else{
            par[parB] = parA;
        }
    }
    //path compression
    public static void main(String args[]){
        init();
        union(1,3);
        System.out.println(find(3));
        union(2,4);
        union(3,6);
        union(1,4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1,5);
    }


}