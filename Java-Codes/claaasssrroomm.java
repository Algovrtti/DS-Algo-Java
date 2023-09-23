import java.util.*;
public class claaasssrroomm{
//     public static void heapify(int arr[] , int i , int size){
//         int left = 2*i+1;
//         int right = 2*i+2;
//         int maxIdx = i;

//         if(left < size && arr[left] > arr[maxIdx]){
//             maxIdx = left;
//         }
//         if(right < size && arr[right]>arr[maxIdx]){
//             maxIdx = right;
//         }
//         if(maxIdx != i){
//             // swap
//             int temp = arr[i];
//             arr[i] = arr[maxIdx];
//             arr[maxIdx] = temp;

//             heapify(arr,maxIdx,size);
//         }
//     }
//     public static void heapsort(int arr[]){
//         // step1 - build maxHeap
//         int n = arr.length;
//         for(int i = n/2; i >= 0;i--){
//             heapify(arr,i,n);
//         }
//         // step2 - push larget at end
//         for(int i = n-1; i>0; i--){
//             // swap(largest- first with last)
//             int temp = arr[0];
//             arr[0] = arr[i];
//             arr[i] = temp;
            
//             heapify(arr,0,i);
//         }
//     }
//     public static void main(String args[]){
//         int arr[] = {1,2,4,5,3};
//         heapsort(arr);

//         //print
//         for(int i = 0; i<arr.length;i++){
//             System.out.print(arr[i]+ " ");
//         }
//         System.out.println();
//     }
// static class point implements Comparable<point> {
//     int x;
//     int y;
//     int distsq;
//     int idx;

//     public point(int x , int y, int distsq,int idx){
//         this.x = x;
//         this.y = y;
//         this.distsq = distsq;
//         this.idx = idx;
//     }
//     @Override
//     public int compareTo(point p2){
//         return this.distsq-p2.distsq;
//     }
// }
// public static void main(String args[]){
//     int pts[][] = {{3,3},{5,-1},{-2,4}};
//     int k = 2;
//     PriorityQueue<point> pq = new PriorityQueue<>();
//     for(int i = 0; i <pts.length ; i++){
//         int distsq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
//         pq.add(new point(pts[i][0],pts[i][1],distsq,i));
//     }
//     // nearest k cars
//     for(int i = 0; i <k ; i++){
//         System.out.println("C"+ pq.remove().idx);
//     }
// }
// public static void main(String args[]){
//     int ropes[] = {2,3,3,4,6};

//     PriorityQueue<Integer> pq = new PriorityQueue<>();
//     for(int i = 0; i <ropes.length; i++){
//         pq.add(ropes[i]);
//     }
//     int cost = 0;
//     while(pq.size() > 1){
//         int min = pq.remove();
//         int min2 = pq.remove();
//         cost += min + min2;
//         pq.add(min + min2);
//     }
//     System.out.println("cost of connecting n ropes ="+ cost);
// }
// static class Row implements Comparable<Row> {
//     int soldiers;
//     int idx;
//     public Row(int soldiers,int idx){
//         this.soldiers = soldiers;
//         this.idx = idx;
//     }

//     @Override
//     public int compareTo(Row r2){
//         if(this.soldiers == r2.soldiers){
//             return this.idx- r2.idx;
//         } else{
//             return this.soldiers- r2.soldiers;
//         }
//     }
// }
// public static void main(String args[]){
//     int army[][] = {{1,0,0,0},
//                     {1,1,1,1},
//                     {1,0,0,0},
//                     {1,0,0,0}};
//     int k = 2;

//     PriorityQueue<Row> pq = new PriorityQueue<>();
//     for(int i = 0 ; i < army.length;i++){
//         int count = 0;
//         for(int j = 0 ; j < army[0].length; j++){
//             count = army[i][j] == 1 ? 1:0;
//         }
//         pq.add(new Row(count,i));
//     }           
//     for(int i =0; i <k ; i++){
//         System.out.println("R"+ pq.remove().idx);
//     }
// 
static class pair implements Comparable<pair> {
    int val;
    int idx;

    public pair(int val,int idx){
        this.val = val;
        this.idx = idx;
    }
    @Override
    public int compareTo(pair p2){
        // acending
        // return this.val- p2.val
        // descending
        return p2.val- this.val;
    }
}
public static void main(String argd[]){
    int arr[] = {1,3,-1,-3,5,3,6,7};
    int k = 3; // window size
    int res[] = new int[arr.length-k+1]; // n-k+1
    PriorityQueue<pair> pq = new PriorityQueue<>();
    
    // 1st window
    for(int i = 0 ; i<k ;i++){
        pq.add(new pair(arr[i],i));
    }
    res[0] = pq.peek().val;
    
    for(int i = k ; i < arr.length; i++){
        while(pq.size() > 0 && pq.peek().idx <= (i-k)){
            pq.remove();
        }
        pq.add(new pair(arr[i],i));
        res[i-k+1] = pq.peek().val;
    }
    // print result
    for(int i = 0; i <res.length ;i++){
        System.out.print(res[i]+" ");
    }
    System.out.println();
}
}