import java.util.*;

public class graphs{
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s,int d ,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        } 
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i = 0 ; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
    graph[0].add(new Edge(0,1,10));
    graph[0].add(new Edge(0,2,15));
    graph[0].add(new Edge(0,3,30));

    graph[1].add(new Edge(1,0,10));
    graph[1].add(new Edge(1,3,40));
    
    graph[2].add(new Edge(2,0,15));
    graph[2].add(new Edge(2,3,50));

    graph[3].add(new Edge(3,1,40));
    graph[3].add(new Edge(3,2,50));
    }
    //  static void createGraph(ArrayList<Edge> graph){
    // graph.add(new Edge(0,1,2));
    // graph.add(new Edge(0,2,4));
    // graph.add(new Edge(1,2,-4));
    // graph.add(new Edge(2,3,2));
    // graph.add(new Edge(3,4,4));
    // graph.add(new Edge(4,1,-1));
    // }
    // public static boolean detectcycle(ArrayList<Edge>[] graph){
    //     boolean vis[] = new boolean[graph.length];
    //     for(int i = 0; i < graph.length ; i++){
    //         if(!vis[i]){
    //            if(detectcycleUtil(graph,vis,i,-1)){
    //                 return true;
    //                 // cycle exists in one of the parts
    //             }
    //         }
    //     }
    //     return false;
    // }
    // public static boolean detectcycleUtil(ArrayList<Edge>[] graph , boolean vis[] , int curr , int par){
    //     vis[curr] = true;

    //     for(int i = 0 ; i< graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         //case3
    //         if(!vis[e.dest]){
    //             if(detectcycleUtil(graph ,vis, e.dest, curr)){
    //                 return true;
    //             }
    //         }
    //             // case 1
    //             else if(vis[e.dest] && e.dest != par){
    //                 return true;
    //             }
    //             // case 2 -> do nothing -> continue
    //     } 
    //     return false;
    // }
    // public static void bfsutil(ArrayList<Edge>[] graph, boolean vis[]){ //O(V+E)
    //     Queue<Integer> q = new ArrayDeque<>();
    //     q.add(0); //source = 0

    //     while(!q.isEmpty()){
    //         int curr = q.remove();

    //         if(!vis[curr]){ // visit curr
    //         System.out.print(curr+" ");
    //         vis[curr] = true;
    //         for(int i = 0; i<graph[curr].size(); i++){
    //             Edge e = graph[curr].get(i);
    //             q.add(e.dest);
    //         }
    //         }
    //     }
    // }
    // public static void dfs(ArrayList<Edge>[] graph){
    //     boolean vis[] = new boolean[graph.length];
    //     for(int i = 0; i < graph.length ; i++){
    //         dfsutil(graph,i,vis);
    //         }
    // }
    // public static void dfsutil(ArrayList<Edge>[] graph, int curr ,boolean vis[]){
    //     //(O+E)
    //     //visit
    //     System.out.print(curr+ " ");
    //     vis[curr] = true;

    //     for(int i = 0; i < graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!vis[e.dest]){
    //             dfsutil(graph, e.dest, vis);
    //         }
    //     }
    // }
    public static boolean haspath(ArrayList<Edge>[] graph , int src , int dest , boolean vis[]){
        if(src == dest){
            return true;
        }
        vis[src] = true;
        for(int i = 0; i < graph[src].size() ; i++){
            Edge e = graph[src].get(i);
            //e.dest = neighbour
            if(!vis[e.dest] && haspath(graph, e.dest , dest , vis)){
                return true;
            }
        }
        return false;
    }
//     public static boolean iscycle(ArrayList<Edge>[] graph){
//         boolean vis[] = new boolean[graph.length];
//         boolean stack[] = new boolean[graph.length];

//         for(int i = 0; i<graph.length ; i++){
//             if(!vis[i]){
//                 if(iscycleUtil(graph, i, vis,stack)){
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
//    public static boolean iscycleUtil(ArrayList<Edge>[] graph , int curr , boolean vis[] , boolean stack[]){
//     vis[curr] = true;
//     stack[curr] = true;

//     for(int i = 0; i < graph[curr].size(); i++){
//         Edge e = graph[curr].get(i);
//         if(stack[e.dest]){ // cycle
//             return true;
//         }
//         if(!vis[e.dest] && iscycleUtil(graph, e.dest,vis,stack)){
//             return true;
//         }
//     } 
//     stack[curr] = false;
//     return false;
//    }
//(O+V)
// public static void topsort1(ArrayList<Edge>[] graph){
//     boolean vis[] = new boolean[graph.length];
//     Stack<Integer> s = new Stack<>();

//     for(int i = 0; i < graph.length ; i++){
//         if(!vis[i]){
//             topsortUtil(graph , i , vis, s); // modified dfs
//         }
//     }
//     while(!s.isEmpty()){
//         System.out.print(s.pop() +" ");
//     }
// }
// public static void topsortUtil1(ArrayList<Edge>[] graph ,int curr , boolean vis[] , Stack<Integer> s){
//     vis[curr] = true;
//     for(int i = 0; i<graph[curr].size(); i++){
//         Edge e = graph[curr].get(i);
//         if(!vis[e.dest]) {
//             topsortUtil(graph, e.dest, vis, s);
//         }
//     }
//     s.push(curr);
// }
// public static void calcIndeg(ArrayList<Edge>[] graph , int indeg[]){
//     for(int i = 0 ; i < graph.length ; i++){
//         int v = i;
//         for(int j = 0 ; j < graph[v].size(); j++){
//             Edge e = graph[v].get(j);
//             indeg[e.dest]++;
//         }
//     }
// }
// public static void topsort(ArrayList<Edge>[] graph){
//     int indeg[] = new int[graph.length];
//     calcIndeg(graph, indeg);
//     Queue<Integer> q = new ArrayDeque<>();

//     for(int i = 0 ; i < indeg.length ;i++){
//         if(indeg[i] == 0){
//             q.add(i);
//         }
//     }
//     // bfs
//     while(!q.isEmpty()){
//         int curr = q.remove();
//         System.out.print(curr +" ");

//         for(int i = 0 ; i < graph[curr].size(); i++){
//             Edge e = graph[curr].get(i);
//             indeg[e.dest]--;
//             if(indeg[e.dest] == 0){
//                 q.add(e.dest);
//             }
//         }
//     }
// }
// public static void printAllpath(ArrayList<Edge>[] graph , int src , int dest , String path){
//     if(src == dest){
//         System.out.println(path+dest);
//         return;
//     }
//     for(int i = 0; i <graph[src].size(); i++){
//         Edge e = graph[src].get(i);
//         printAllpath(graph, e.dest,dest,path+src);
//     }
// }
// static class pair implements Comparable<pair>{
//     int n;
//     int path;
//     public pair(int n, int path){
//         this.n = n;
//         this.path = path;
//     }

//     @Override
//     public int compareTo(pair p2){
//         return this.path-p2.path; // path based sorting for my pair
//     }
// }
// public static void dijkstra(ArrayList<Edge>[] graph, int src){
//     int dist[] = new int[graph.length]; //dist[i] -> src to i
//     for(int i = 0 ; i < graph.length ; i++){
//         if(i != src){
//             dist[i]= Integer.MAX_VALUE; //+infity
//         }
//     }
//     boolean vis[] = new boolean[graph.length];
//     PriorityQueue<pair> pq = new PriorityQueue<>();
//     pq.add(new pair(src,0));
//     //loop
//     while(!pq.isEmpty()){
//         pair curr = pq.remove();
//         if(!vis[curr.n]){
//             vis[curr.n] = true;
//             //neighhours
//             for(int i = 0 ; i < graph[curr.n].size(); i++){
//                 Edge e = graph[curr.n].get(i);
//                 int u = e.src;
//                 int v = e.dest;
//                 int wt = e.wt;

//                 if(dist[u] + wt < dist[v]) { // update distance of src to v;
//                     dist[v] = dist[u] + wt;
//                     pq.add(new pair(v, dist[v]));
//                 }
//             }
//         }
//     }
//     // print all source to vertices shortest dist
//     for(int i = 0; i <dist.length ; i++){
//         System.out.print(dist[i] + "");
//     }
//     System.out.println();
// }
// public static void bellmanford(ArrayList<Edge> graph[] , int src){
//     int dist[] = new int[graph.length];
//     for(int i = 0 ; i < dist.length; i++){
//         if(i != src){
//             dist[i] = Integer.MAX_VALUE;
//         }
//     }
//     int V = graph.length;
//     //algo
//     for(int i = 0; i<V-1 ; i++){
//         //Edge - O(E)
//         for(int j = 0 ; j<graph.length ; j++){
//             for(int k = 0; k < graph[j].size(); k++){
//                 Edge e = graph[j].get(k);
//                 // u,v,wt
//                 int u = e.src;
//                 int v = e.dest;
//                 int wt = e.wt;
//                 //relaxation
//                 if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
//                     dist[v] = dist[u] + wt;
//                 }
//             }
//         }
//     }
//     //print 
//     for(int i = 0 ; i <dist.length ; i++){
//         System.out.print(dist[i] + " ");
//     }
//     System.out.println();
// }
// public static void bellmanford(ArrayList<Edge> graph , int src, int V){
//     int dist[] = new int[V];
//     for(int i = 0 ; i < dist.length; i++){
//         if(i != src){
//             dist[i] = Integer.MAX_VALUE;
//         }
//     }
//     //O(VE)
//     for(int i = 0; i < V-1 ; i++){
//         //Edge - O(E)
//         for(int j = 0 ; j<graph.size() ; j++){
//                 Edge e = graph.get(j);
//                 // u,v,wt
//                 int u = e.src;
//                 int v = e.dest;
//                 int wt = e.wt;
//                 //relaxation
//                 if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
//                     dist[v] = dist[u] + wt;
                
//             }
//         }
//     }
//     //print 
//     for(int i = 0 ; i <dist.length ; i++){
//         System.out.print(dist[i] + " ");
//     }
//     System.out.println();
// }
static class Pair implements Comparable<Pair>{
    int v;
    int cost;

    public Pair(int v , int c){
        this.v = v;
        this.cost = c;
    }

    @Override
    public int compareTo( Pair p2){
        return this.cost-p2.cost;
    }
}
public static void prims(ArrayList<Edge> graph[]){
    boolean vis[] = new boolean[graph.length];
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0,0));
    int Finalcost = 0; // MST cost/ total min weight

    while(!pq.isEmpty()){
        Pair curr = pq.remove();
        if(!vis[curr.v]){
            vis[curr.v] =true;
            Finalcost += curr.cost;

            for(int i = 0; i < graph[curr.v].size() ; i++){
                Edge e = graph[curr.v].get(i);
                pq.add(new Pair(e.dest ,e.wt));
            }
        }
    }
    System.out.println("final(min) cost of MST =" + Finalcost);
}
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);

    }
}
