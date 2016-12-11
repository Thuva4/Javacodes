import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 10/2/16.
 */
public class solution3 {
    public static void main(String[] srgs){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int p = scan.nextInt();
        int t = scan.nextInt();
        scan.nextLine();
        ArrayList<String []> array1 = new ArrayList<>();
        for (int i=0;i<p;i++){
            String [] str = scan.nextLine().split(" ");
            array1.add(str);
        }
        int total = Integer.MAX_VALUE;
//        for()
    }
}
