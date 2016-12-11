import java.util.Scanner;

/**
 * Created by smtt on 11/22/16.
 */
public class BotClean {

        public static void main(String [] args){
            Scanner scanner = new Scanner(System.in);
            int size = scanner.nextInt();
            String[][] grid = new String[size][size];
            int boty=scanner.nextInt(),botx=scanner.nextInt();
            scanner.nextLine();
            for(int i =0;i<size;i++){
                String [] str = scanner.nextLine().split("");
                for(int j=0;j<size;j++){
                    grid[i][j] = str[j];
                }
            }
          



    }
}
