import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by smtt on 10/24/16.
 */
public class fibo {
    static  Map<Long,Long> map = new HashMap<>();
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        long test = scanner.nextInt();
        for(int i=0;i<test;i++) {
            long n = scanner.nextLong();
            boolean b = isfo(n);
            if (b) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }

    }
    static boolean isfo(long n){
        boolean cond =true;
        int i=0;
        while(cond){
            if(fibo(i)==n){
                return true;
            }
            else if(fibo(i)<n){
                i++;
            }
            else{
                return false;
            }
        }
        return false;
    }
    static long fibo(long m){
        if(map.get(m)!=null){
            return map.get(m);
        }
        else if(m==0){
            map.put(m,(long)0);
            return 0;
        }
        else if(m==1){
            map.put(m,(long)1);
            return 1;
        }
        else {
            long k= fibo(m-1)+fibo(m-2);
            map.put(m,k);
            return k;
        }
    }
}
