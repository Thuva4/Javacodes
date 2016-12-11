import java.io.*;
import java.util.*;

public class maze {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        int size = n*(n+1)/2;
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        int count=0;
        boolean flag = false;
        while(2>1){
            count++;
            int x= scan.nextInt();
            if(x==-1) break;
            int y = scan.nextInt();


        }
        if(flag==false){
            System.out.println((-1));
        }
    }
    boolean funcheck(int n,int[][] arr) {
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                index = i;
            }
        }
        return true;
    }
}