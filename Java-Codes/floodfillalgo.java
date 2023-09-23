import java.util.*;

public class floodfillalgo{
    public int[][] helper(int[][] image, int sr , int sc, int color,boolean vis[][] , int orgCol){
        image[sr][sc]= color;
        if(sr <0 || sc <0 || sr >= image.length || sc >= image[0].length 
        ||  vis[sr][sc] || image[sr][sc] != orgCol){
            return;
        }

        //left
        helper(int[][] image, int sr , int sc-1, int color,boolean vis[][] , int orgCol);
        //right
        helper(int[][] image, int sr , int sc+1, int color,boolean vis[][] , int orgCol);
        //up
        helper(int[][] image, int sr-1, int sc, int color,boolean vis[][] , int orgCol);
        //down
        helper(int[][] image, int sr , int sc-1, int color,boolean vis[][] , int orgCol);
    }
    public int[][] floodfill(int[][] image, int sr , int sc, int color){
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }
    public static void main(String args[]){
        int[][] image = {{1,1,1},
                         {1,1,0},
                         {1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        System.out.pritnln(floodfill(int[][] image, int sr , int sc, int color));
    }
}