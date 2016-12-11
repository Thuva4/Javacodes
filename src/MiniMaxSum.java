import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 11/12/16.
 */
public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long [] list = new long[5];

        list[0] =in.nextLong();
        list[1]=in.nextLong();
        list[2]=in.nextLong();
        list[3]=in.nextLong();
        list[4]=in.nextLong();

        Arrays.sort(list);
        System.out.print(list[0]+list[1]+list[2]+list[3] +  " " + list[4]+list[1]+list[2]+list[3] );

    }
}

