import java.util.*;
public class CLASSroooommmmm{
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
        public static Node createBST(int arr[],int st, int end){
            if(st > end){
                return null;
            }
            int mid = (st+end)/2;
            Node root = new Node(arr[mid]);
            root.left = createBST(arr,st,mid-1);
            root.right = createBST(arr, mid+1,end);
            return root;
        }
        public static void getInorder(Node root, ArrayList<Integer> inorder){
            if(root == null){
                return;
            }

            getInorder(root.left,inorder);
            inorder.add(root.data);
            getInorder(root.right,inorder);
        }
        public static Node createbST(ArrayList<Integer> inorder,int st,int end){
            if(st > end){
                return null;
            }
            int mid = (st+end)/2;
            Node root = new Node(inorder.get(mid));
            root.left = createbST(inorder, st,mid-1);
            root.right = createbST(inorder,mid+1,end);
            return root;
        }
        public static Node BalancedBST(Node root){
            // inorder seq
            ArrayList<Integer> inorder = new ArrayList<>();
            getInorder(root,inorder);
            //sorted inorder -> balanced BST
            root = createbST(inorder,0,inorder.size()-1);
            return root;
        }
    public static void main(String args[]){
        Node root = new Node( 8);
        root.left = new Node( 6);
        root.left.left = new Node( 5);
        root.left.left.left = new Node( 3);
        root.right = new Node( 10);
        root.right.right = new Node( 11);
        root.right.right.right = new Node( 12);
        root = BalancedBST(root);
        preorder(root);
    }
}
