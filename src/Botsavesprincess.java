import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 11/7/16.
 */
public class Botsavesprincess {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        scanner.nextLine();
        String[][] grid = new String[size][size];
        int botx=0,boty=0;
        int prinx=0,priny=0;
        for(int i =0;i<size;i++){
            String [] str = scanner.nextLine().split("");
            for(int j=0;j<size;j++){
                grid[i][j] = str[j];
                if(str[j].equals("m")){
                    botx =j;
                    boty=i;
                }
                if(str[j].equals("p")){
                    prinx =j;
                    priny=i;
                }
            }
        }
        System.out.println(prinx + " "+ priny);
        System.out.println(botx + " "+ boty);
        if(botx>prinx){
            System.out.println("1");
            while(botx>prinx){
                System.out.println("LEFT");
                botx--;
            }
        }
        else if(botx<prinx){
            while(botx<prinx){
                System.out.println("RIGHT");
                botx++;
            }
        }

        if(boty>priny){
            while(boty>priny){
                System.out.println("UP");
                boty--;
            }
        }
        else if(boty<priny){
            while(boty<priny){
                System.out.println("DOWN");
                boty++;
            }
        }


    }

}
