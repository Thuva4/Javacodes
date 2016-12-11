import java.util.Scanner;

public class Totient {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        Scanner scanner=new Scanner(System.in);
        int test = scanner.nextInt();
        for(int i =0;i<test;i++){
            int N = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(phifunc(N,A,B)%1000000007);
        }
    }

    static int gcd(int a, int b){
        int c;
        while(b!=0){
            c=a%b;
            a=b;b=c;
        }
        return a;
    }

    static int phifunc(int n,int a,int b){
        int c=0;

        for(int i=a;i<b+1;i+=n%2<1?2:1) {
            if (gcd(n, i) == 1)
                c += i;
        }

        return c;
    }
}