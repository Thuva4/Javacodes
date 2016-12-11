import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 11/7/16.
 */
public class Botsavesprincess2 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        String[][] grid = new String[size][size];
        int boty=scanner.nextInt(),botx=scanner.nextInt();
        int prinx=0,priny=0;
        scanner.nextLine();
        for(int i =0;i<size;i++){
            String [] str = scanner.nextLine().split("");
            for(int j=0;j<size;j++){
                grid[i][j] = str[j];
                if(str[j].equals("p")){
                    prinx =j;
                    priny=i;
                }
            }
        }
        if(prinx<botx){
            System.out.println("LEFT");
        }
        else if(prinx>botx){
            System.out.println("RIGHT");
        }
        else if(priny<boty){
            System.out.println("UP");
        }
        else if(priny>boty){
            System.out.println("DOWN");
        }


    }

}
