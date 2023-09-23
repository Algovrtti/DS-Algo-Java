public class patterns {
  // public static void hollow_rectangle(char totrows ,char totcols){
  //   for(char i = 1; i<=totrows; i++){
  //     for(char j =1; j<=totcols; j++) {
  //       if(i == 1 || i == totrows || j == 1 || j == totcols ){
  //         System.out.print("*");
  //       } else {
  //         System.out.print(" ");
  //       }
  //     }
  //      System.out.println();

  //   }
  // }
  // public static void inverted_rotated_half_piramind(char n) {
  //   for(char i = 1; i<=n;i++) {
  //     for(char j = 1; j<=n-i;j++) {
  //       System.out.print(" ");
  //     }
  //     for(char j = 1;j<=i;j++) {
  //       System.out.print("*");
  //     }
  //     System.out.println();
  //   }
  // }
  // public static void inverted_half_piramindwithnumbers(char n) {
  //   for(char i =1 ; i <=n ; i++) {
  //     for(char j = 1 ; j <=n-i+1 ; j++){
  //     System.out.print(j +" ");
  //     }
  //      System.out.println();
  //   }
  // }
  // public static void floyds_triangle(char n ) {
  //    char counter = 1;
  //   for(char i = 1; i <= n ;i++) {
  //     for(char j = 1 ; j <= i ; j++){
  //       System.out.print(counter + " ");
  //       counter++;
  //     }
  //     System.out.println();
  //   }
  // } 
  // public static void zero_one_triangle(char n) {
  //   for(char i = 1; i<=n; i++) {
  //     for(char j =1; j<=i;j++){
  //       if((i+j) % 2 == 0) {
  //         System.out.print("1");
  //       } else{
  //         System.out.print("0");
  //       }
  //     }
  //      System.out.println();
  //   }
  public static void butterfly(char n) {
    // 1 half
    for(char i = 1; i<=n ; i++) {
      // star n <=i
      for(char j = 1 ; j<=i ; j++) {
      System.out.print("*");
      }
      // spaces n <= 2*n-1
      for(char j = 1 ; j<= 2*(n-i) ; j++) {
        System.out.print(" ");
      }
      // star n <=i
      for(char j = 1; j<=i ; j++) {
        System.out.print("*");
      }
       System.out.println();
    }
  // 2 half
    for(char i = n ; i>=1; i--) {
         // star n <=i
      for(char j = 1 ; j<=i ; j++) {
      System.out.print("*");
      }
      // spaces n <= 2*n-1
      for(char j = 1 ; j<= 2*(n-i) ; j++) {
        System.out.print(" ");
      }
      // star n <=i
      for(char j = 1; j<=i ; j++) {
        System.out.print("*");
      }
      System.out.println();
    } 
  }
  public static void sloid_rombus(char n) {
    for(char i = 1; i <=n ; i++) {
      //  spaces
      for(char j = 1 ; j <= n-i ; j++) {
        System.out.print(" ");
      }
      // stars
      for(char j = 1; j <= n ; j++) {
        System.out.print("*");
      }
      System.out.println();
      }
    }
    public static void hollow_rhombus(char n) {
      for (char i = 1 ; i <=n ; i++) {
        // spacees
        for(char j = 1 ; j <= n-i ; j++) {
          System.out.print(" ");
        }
        // hollow_rectangle
        for(char j = 1 ; j <= n ; j++) {
          if(i == 1 || i == n || j == 1 || j == n) {
            System.out.print("*");
          } else {  
            System.out.print(" ");
          } 
          
        }
         System.out.println();
      }
    }
    public static void diamond(char n) {
      //  1 half
      for(char i  = 1 ; i <= n ; i++) {
        //  spaces
        for ( char j = 1 ; j <= n-i ; j++) {
          System.out.print(" ");
        }
      //  stars
      for(char j = 1 ; j <= (2*i)-1 ; j++) {
        System.out.print("*");
      }
      System.out.println();
      }
       //  2 half
      for(char i  = n ; i >= 1 ; i--) {
        //  spaces
        for ( char j = 1 ; j <= n-i ; j++) {
          System.out.print(" ");
        }
      //  stars
      for(char j= 1 ; j <= (2*i)-1 ; j++) {
        System.out.print("*");
      }
      System.out.println();
      }
      
        }
        public static void number_pyramid(char n) {
          for(char i = 1 ; i <= n ; i++) {
            // spaces
            for(char j = 1 ; j<= n-i ; j++) {
              System.out.print(" ");
            }
            // numbers
            for(char j = 1 ; j <= i ; j++) {
              System.out.print(i + " ");
            }
            System.out.println();
          }
          }
          public static void palindromic_with_numbers(char n) {
            for(char i = 1 ; i <= n ; i++) {
              //  spaces
              for(char j = 1 ; j <= n-i ; j++) {
                System.out.print(" ");
              }
              //  numbers
              // desanding
              for(char j = i ; j >= 1 ; j--) {
              System.out.print(j);
              }
              for(char j = 2 ; j <= i ; j++) {
                System.out.print(j);
              }
              System.out.println();
            } 
            
          }
           
          
  public static void main(String args[]) {
  //  inverted_rotated_half_piramind(5); 
  // inverted_half_piramindwithnumbers(5);
  // floyds_triangle(41);
  // zero_one_triangle(5);
  //  butterfly(4); 
  //  sloid_rombus(4);
  // hollow_rhombus(5);
  // diamond(4);
  // number_pyramid(5);
  palindromic_with_numbers(58);
  }
}



   