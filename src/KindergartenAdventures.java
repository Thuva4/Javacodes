import java.security.PublicKey;
import java.util.Scanner;

/**
 * Created by smtt on 11/12/16.
 */
public class KindergartenAdventures {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] list = new int[n];
        for(int i=0;i<n;i++){
            list[i]=scanner.nextInt();

        }

        for(int j=0;j<n;j++){
            if(list[j]==0){
                System.out.println(j+1);
                break;
            }
        }
    }
}
