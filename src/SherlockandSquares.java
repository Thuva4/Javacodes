/**
 * Created by smtt on 11/6/16.
 */

import java.io.*;
import java.util.*;
public class SherlockandSquares {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();
        for (int i = 0; i < test; i++) {
            int n = scan.nextInt();
            int m = scan.nextInt();
//            System.out.println(n + " "+ m);
            int min = 0;
            int max = -1;
            boolean con = false;
            for (int j = n; j <=m; j++) {
//                System.out.println(Math.sqrt(j)-(int) Math.sqrt(j));
                if (Math.sqrt(j) - (int) Math.sqrt(j) == 0.0) {
                    con = true;
                    min = (int) Math.sqrt(j);
                    break;
                }
            }
//            System.out.println(max +" "+ min);
                int k=m;
                while (k>=n && con){
//                    System.out.println(k);
                    if (Math.sqrt(k) - (int) Math.sqrt(k) == 0) {
                        con = false;

                        max = (int)Math.sqrt(k) ;

                    }

                        k--;

                }

//            System.out.println(max +" "+ min);
            System.out.println(max-min+1);


        }
    }
}
