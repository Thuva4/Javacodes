import java.util.Scanner;

/**
 * Created by smtt on 11/3/16.
 */
public class BetweenTwoSets {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int [] a = new int[n];
        int [] b = new int[m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            a[i] = scanner.nextInt();
            if(a[i]>max){
                max=a[i];
            }
        }
        for(int i=0;i<m;i++){
            b[i] = scanner.nextInt();
            if(b[i]<min){
                min=b[i];
            }
        }
        int total =0;
        for(int j = max ; j<=min;j++){
            boolean cond = true;
            for(int i =0;i<n;i++){
                if(j%a[i]!=0){
                    cond=false;
                }
            }
            if(cond){
                for(int i =0;i<m;i++){
                    if(b[i]%j!=0){
                        cond=false;
                    }
                }
            }
            if(cond){
                total++;
            }
        }
        System.out.println(total);


    }


}
