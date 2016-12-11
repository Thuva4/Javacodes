import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 10/10/16.
 */
public class Sumitup {
    public static void main(String [] a){
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Long [] arr = new Long[size];
        scanner.nextLine();
        String [] strin = scanner.nextLine().split(" ");
        int i=0;
        for(String s: strin){
            arr[i] =Long.parseLong(s);
            i++;
        }
        int op = scanner.nextInt();
        for(int l=0;l<op;l++){
//            int previous =0;
            Long [] te = new Long[arr.length];
            int aa = scanner.nextInt();
            for(int o =0 ;o<arr.length;o++ ){
                Long temp = arr[o];

                if(o-aa<0){
                    int index = o-aa+arr.length;
                    te[o] = temp+arr[index];
                }
                else{
                    te[o] = temp+arr[o-aa];
                }
            }
            arr = te;
        }
        Long sum =new Long(0);
        for(Long l :arr){
            sum+=l;
        }
        Long j = (long) (sum % (Math.pow(10,9)+7));
        System.out.println(j);

    }
}
