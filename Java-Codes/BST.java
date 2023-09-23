import java.util.*;
public class BST{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root,int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left , val);
        } else {
            //right.subtree
            root.right = insert(root.right,val);
        }
        return root;
    }
    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static boolean search(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(root.data > key){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }
    
    public static Node delete(Node root,int val){
        if(root.data < val){
            root.right = delete(root.right,val);
        }
        else if(root.data > val){
            root.left = delete(root.left,val);
        }
        else{//voila
             //case1 - leaf Node
             if(root.left == null && root.right == null){
                return null;
             }   
             // case 2 single child
             if(root.left == null){
                return root.right;
             }
             else if(root.right == null){
                return root.left;
             }
             // case 2 - both children
             Node IS = findInorderSucssesor(root.right);
                root.data = IS.data;
                root.right = delete(root.right,IS.data);
             }
             return root;
        
    }
        public static Node findInorderSucssesor(Node root){
            while(root.right != null){
                root = root.left;
            }
            return root;
        }
        public static void printInRange(Node root, int k1,int k2){
            if(root == null){
                return;
            }
            if(root.data >= k1 && root.data <= k2){
                printInRange(root.left,k1,k2);
                System.out.print(root.data+ " ");
                printInRange(root.right,k1,k2);
            }
            else if(root.data < k1){
                printInRange(root.left,k1,k2);
            }
            else{
                printInRange(root.right,k1,k2);
            }
        }
        public static void printpath(ArrayList<Integer> path){
            for(int i = 0; i < path.size(); i++){
                System.out.print(path.get(i)+ "->");
            }
            System.out.println("null");
        }
        public static void printRoot2Leaf(Node root,ArrayList<Integer> path){
            if(root == null){
                return;
            }
            path.add(root.data);
            if(root.left == null && root.right == null){
                printpath(path);
            }
            printRoot2Leaf(root.left,path);
            printRoot2Leaf(root.right,path);
            path.remove(path.size()-1);
        }
        public static boolean IsValidBST(Node root, Node min, Node max){
            if(root == null){
                return true;
            }
            if(min != null && root.data <= min.data){
                return false;
            }
            else if(max != null && root.data >= max.data){
                return false;
            }
            return IsValidBST(root.left,min,root)
            && IsValidBST(root.right,root,max);
        }
    public static void main(String args[]){
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;
        for(int i = 0; i <values.length;i++){
            root = insert(root,values[i]);
        }
        inorder(root);
        System.out.println();

       if(IsValidBST(root,null,null)){
        System.out.print("valid");
       } else{
        System.out.print("not valis");
       }
}
}