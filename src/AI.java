import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by smtt on 10/21/16.
 */
public class AI {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String f =scanner.nextLine();
        String [] s = f.split("");

        boolean cond =true;
        while(cond){
            for(int j =s.length-1;j>0;j--){
                String temp = s[j];
                s[j]=s[j-1];
                s[j-1]=temp;
                String g ="";
               for(String h:s){
                g+=h;
            }
            System.out.println(g);
            }
            String g ="";
            for(String h:s){
                g+=h;
            }
            if(g.equals(f)){
                cond=false;
            }
        }


    }
}
