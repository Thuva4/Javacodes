import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.StreamSupport;

//#include <bits/stdc++.h>
//        using namespace std;
//        #define F(i,a,b) for(int i = (int)(a); i <= (int)(b); i++)
//        #define RF(i,a,b) for(int i = (int)(a); i >= (int)(b); i--)
//        int main()
//        {
//        int X,Y; //X:number of rows, Y: number of columns
//        X = Y = 4; //assuming 10X10 matrix1
//        int Cost[X][Y];
//
//        F(i,0,X-1)
//        {
//        F(j,0,Y-1)
//        {
//        cin>>Cost[i][j];
//        }
//        }
//
//        int MinCost[X][Y]; //declare the minCost matrix
//
//        MinCost[0][0] = Cost[0][0];
//
//        // initialize first row of MinCost matrix
//        F(j,1,Y-1)
//        MinCost[0][j] = MinCost[0][j-1] + Cost[0][j];
//
//        //Initialize first column of MinCost Matrix
//        F(i,1,X-1)
//        MinCost[i][0] = MinCost[i-1][0] + Cost[i][0];
//
//        //This bottom-up approach ensures that all the sub-problems needed
//        // have already been calculated.
//        F(i,1,X-1)
//        {
//        F(j,1,Y-1)
//        {
//        //Calculate cost of visiting (i,j) using the
//        //recurrence relation discussed above
//        MinCost[i][j] = min(MinCost[i-1][j],MinCost[i][j-1]) + Cost[i][j];
//        }
//        }
//
//        cout<<"Minimum cost from (0,0) to (X,Y) is "<<MinCost[X-1][Y-1];
//        return 0;
//        }
public class pirates{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        scanner.nextLine();
        String [][] cost = new String[n][m];
        for(int i =0;i<n;i++){
            String [] str=scanner.nextLine().split("");
            System.out.println(Arrays.toString(str));
            for(int j =0;j<m;j++){
//                System.out.println(j);
                cost[i][j]=str[j];
            }
            System.out.println(Arrays.toString(cost[i]));
        }
        int [][] min_cost = new int[n][m];
        min_cost[2][2] = getcost(cost[2][2]);

        for(int j=3;j<m;j++){
            min_cost[0][j] = min_cost[0][j-1] + getcost(cost[0][j]);
        }
        for(int j=3;j<n;j++){
            min_cost[j][0] = min_cost[j-1][0] + getcost(cost[j][0]);
        }

        for(int i=3;i<3;i++){
            for (int j=2;j<11;j++){
                min_cost[i][j] = Math.min(min_cost[i-1][j],min_cost[i][j-1]) + getcost(cost[i][j]);
            }
        }
        System.out.println(min_cost[n-1][m-1]);

    }

    public static int getcost(String s){
        if(s.equals("O")){
            return 1;
        }
        else{
            return 0;
        }
    }

}