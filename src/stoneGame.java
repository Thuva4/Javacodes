import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by smtt on 10/22/16.
 */
public class stoneGame {
    public static void main(String[] args){
        Scanner scan= new Scanner(System.in);
        int cases=scan.nextInt();
        for(int i=0;i<cases;i++){
            int games=scan.nextInt();
            int piles=0;
            ArrayList<int[]> data= new  ArrayList<>();
            for(int x=0;x<games;x++){
                piles=scan.nextInt();
                int[] pi=new int[piles];
                for(int j=0;j<piles;j++){
                    pi[j]=scan.nextInt();
                }
                data.add(pi);
            }
            int tot=0;
            for(int[] a:data){
                for(int b:a){
                    tot+=(b-1)/2;
                }
            }
            if(tot%2==1){
                System.out.println("Alice");
            }
            else{
                System.out.println("Bob");
            }
        }

    }
}
