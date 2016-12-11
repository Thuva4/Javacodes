import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 10/21/16.
 */
public class Kabloom {
    public static int add(String a,String b){
        if(a.equals("R")){
            if (b.equals("R")) {
                return 50;
            }
            else if(b.equals("A"))return 20;
            else if(b.equals("Q"))return 15;
            else if(b.equals("K"))return 15;
            else if(b.equals("J"))return 15;
            else if(b.equals("T"))return 10;
            else {
            return Integer.parseInt(b);
            }
        }
       else if(b.equals("R")){
            if (a.equals("R")) {
                return 50;
            }
            else if(a.equals("A"))return 20;
            else if(a.equals("Q"))return 15;
            else if(a.equals("K"))return 15;
            else if(a.equals("J"))return 15;
            else if(a.equals("T"))return 10;
            else {
                return Integer.parseInt(a);
            }
        }
        else if(a.equals("A"))return 20;
        else if(a.equals("Q"))return 15;
        else if(a.equals("K"))return 15;
        else if(a.equals("J"))return 15;
        else if(a.equals("T"))return 10;
        else {
            return Integer.parseInt(a);
        }

    }



    public static void main(String [] args){


        Scanner scanner = new Scanner(System.in);

        int n=scanner.nextInt();
        scanner.nextLine();
        while (n!=0) {
//            System.out.println(n);
            String[][] a = new String[n + 1][5];
            String[][] b = new String[n + 1][5];
            int[][] dp = new int[n + 1][n + 1];
            String[] k = scanner.nextLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                a[i][0] = k[i - 1];
            }
//            System.out.println(Arrays.deepToString(a));
            String[] h = scanner.nextLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                b[i][0] = h[i - 1];
            }

            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (a[i][0].equals(b[j][0]) || a[i][0].equals("R") || b[j][0].equals("R")) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + add(a[i][0], b[j][0]));
                    }
                }
            }
            System.out.println(Arrays.deepToString(dp));
            System.out.println(dp[n][n] * 2);
            n=Integer.parseInt(scanner.nextLine().split("")[0]);
        }
    }
}
