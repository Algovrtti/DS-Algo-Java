import java.util.*;
public class classssroooom{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
    public static void getInorder(Node root, ArrayList<Integer> arr){
        if(root == null){
            return;
        }
        getInorder(root.left,arr);
        arr.add(root.data);
        getInorder(root.right,arr);   
    }
     public static Node createBST(ArrayList<Integer> arr,int st,int end){
            if(st>end){
                return null;
            }
            int mid = (st+end)/2;
            Node root = new Node(arr.get(mid));
            root.left = createBST(arr,st, mid-1);
            root.right = createBST(arr,mid+1,end);
            return root;
        }
    public static Node MergeBSTs(Node root1, Node root2){
        // step 1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1,arr1);
        // step 2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2,arr2);
        // merge
        int i = 0, j =0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else{
                finalArr.add(arr2.get(j));
                j++;
            }
        }
        while(i< arr1.size()){
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j < arr2.size()){
            finalArr.add(arr2.get(j));
            j++;
        }
        // stored AL -> balanced BST
        return createBST(finalArr,0,finalArr.size()-1);
    }
    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    // static class Info{
    //     boolean isBST;
    //     int size;
    //     int min;
    //     int max;
    //     public Info( boolean isBST,int size, int min,int max){
    //         this.isBST = isBST;
    //         this.size = size;
    //         this.min = min;
    //         this.max = max;
    //     }
    // }
    // public static int maxBST = 0;
    // public static Info largsetBST(Node root){
    //     if(root == null){
    //         return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
    //     }
    //     Info leftInfo = largsetBST(root.left);
    //     Info rightInfo = largsetBST(root.right);
    //     int size = leftInfo.size + rightInfo.size + 1;
    //     int min = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
    //     int max = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
    //     if(root.data <= leftInfo.max || root.data >= rightInfo.min){
    //         return new Info(false,size,min,max);
    //     }
    //     if(leftInfo.isBST &&rightInfo.isBST){
    //         maxBST = Math.max(maxBST,size);
    //         return new Info(true,size,min,max);
    //     }
    //     return new Info(false,size,min,max);
    // }
    public static void main(String args[]){
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);
        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);
        // Info Info = largsetBST(root);
        // System.out.println("larget BST size =" + maxBST);
        Node root = MergeBSTs(root1,root2);
        preorder(root);
    }
}
