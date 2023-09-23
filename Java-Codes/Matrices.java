import java.util.*;

public class Matrices {
    public static void printspiral(int matrix[][]) {
        int startrow = 0;
        int startcol = 0;
        int endrow = matrix.length-1;
        int endcol = matrix[0].length-1;
        while(startrow <= endrow && startcol <= endcol) {
            // top 
            for(int j = startcol; j <= endcol ; j++) {
                System.out.print(matrix[startrow][j] + " ");
            }
            // right
            for(int i = startrow+1 ; i <=endrow ; i++) {
                System.out.print(matrix[i][endcol]+ " ");
            }
            // bottom
            for(int j = endcol-1 ; j >= startcol ; j--) {
                if(startcol == endcol) {
                    break;
                }
                System.out.print(matrix[endrow][j] + " ");
            }
            // left
            for(int i = endrow-1 ; i >= startrow+1 ; i--) {
                System.out.print(matrix[i][startcol] + " ");
            }
            startcol++;
            startrow++;
            endcol--;
            endrow--;
        }
        System.out.println();
    }
    public static int diagnalsum(int matrix[][]) {
        int sum = 0;
        for(int i = 0; i <matrix.length; i++) {
            for(int j = 0 ; j<matrix[0].length; j++) {
                if(i == j) {
                    sum+= matrix[i][j];
                }
                else if(i+j == matrix.length-1) {
                    sum+= matrix[i][j];
                }
            }
        }
    for(int i = 0; i <=matrix.length-1;i++) {
        // pd
        sum+= matrix[i][i];
        // sd
        if(i!= matrix.length-1-i)
            sum+= matrix[i][matrix.length-i-1];
    }
    return sum;
    }
    public static boolean staircasesearch(int matrix[][] , int key) {
        int row = matrix.length-1 , col = 0;
        while(row >= 0 && col < matrix[0].length) {
            if(matrix[row][col] == key) {
                System.out.println("key is found at (" + row +"," + col + ")");
                return true;
            }
            else if(key < matrix[row][col]) {
                row--;
            }
            else{
                col++;
            }
        }
        System.out.println("key not found");
        return false;
    }
    public static void numberstimes(int matrix[][], int key) {
        int times = 0;
        for(int i = 0 ; i <= matrix.length-1 ; i++) {
            for(int j = 0 ; j <= matrix[0].length-1 ; j++) {
                if(matrix[i][j]== key){
                times++;
                }
            }
        }
        System.out.println(times);
    }
    public static int sumofarray(int matrix [][]) {
        int sum = 0;
        for(int i = 1 ; i <= 1 ; i++) {
            for(int j = 0 ; j <= matrix.length-1 ; j++) {
                sum += matrix[i][j];
            }
            System.out.println(sum);
        }
        return sum;
    }
            
    }
    public static void transposematrix(int matrix[][]) {
         for(int i = 0 ; i <=row ; i++) {
            for(int j =  ; j <= col ; j++) {
                transpose[j][i] = matrix[i][j] ;
            }
        }
    

    public static void printmatrix(int transposematrix[][]) {
        System.out.println("your matrix is :");
        for(int i =  ; i <= matrix.length-1 ; i++) {
            for(int j =  ; j <= matrix[0].length ; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            Systm.out.println();
        }
    }
    public static void main(String args[]) {
        int row = 2 , col=3 ;
        int matrix[][] = {{2,3,7}, {5,6,7}};

       
        // int key = 7;                  
        // printspiral(matrix);
        // System.out.println(diagnalsum(matrix));
        // staircasesearch(matrix,key);
        // numberstimes(matrix,key);
        // sumofarray(matrix):
        printmatrix(transposematrix);
    }
    }
    
   
