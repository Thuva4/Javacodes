import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by smtt on 10/11/16.
 */
public class CircularArrayRotation {
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int temp = 0;

        int [] b = new int[n];
        b=a.clone();
        for(int i =0;i<a.length;i++){
            b[(i+k)%a.length] = a[i];
            System.out.println(Arrays.toString(b));
        }
        a = b;


//        for(int j=0;j<k;j++) {
//            for (int i = 0; i < a.length; i++) {
//                int pre = a[i];
//                if ((i - k+a.length) < 0) {
//                    temp = a[a.length - 1];
//                    a[i] = temp;
//                    temp = pre;
//                } else {
////                temp = pre;
//                    a[i] = temp;
//                    temp = pre;
//                }
////                System.out.println(temp);
//
//            }
////            System.out.println(Arrays.toString(a));
//        }
            for(int a0 = 0; a0 < q; a0++){
                int m = in.nextInt();
//                System.out.println(m);
//                List<Integer> aa = Arrays.asList(a);
                System.out.println(a[m]);

            }
    }
}
