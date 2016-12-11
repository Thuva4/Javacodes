import java.util.Scanner;

/**
 * Created by smtt on 10/21/16.
 */
public class LetMeCountTheWays {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int []coins = {50,25,10,5,1};
        int n = scanner.nextInt();
        int [] nways = new int[n+1];
        nways[0]=1;
        for (int i =0;i<5;i++){
            for(int j=coins[i];j<=n;j++){
                nways[j]+=nways[j-coins[i]];
            }
        }
        System.out.println(nways[n]);


    }
}
