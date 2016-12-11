import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by smtt on 10/11/16.
 */
public class RepeatedString {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Long n = scanner.nextLong();
        Long k = n/s.length();
        Long p = n%s.length();
//        args.length
        int count = s.length() - s.replace("a", "").length();

        String [] aa = s.split("");
        int total=0;
        ArrayList<Integer> in = new ArrayList<>();
        int la =0;
        for(String j: aa){
            if(j.equals("a")){
                total++;
                in.add(la);
            }
            la++;
        }
        int fina =0;
        for(int i: in){
            if(i<p){
                fina++;
            }
        }

        System.out.println((total*k) + fina);


    }
}
