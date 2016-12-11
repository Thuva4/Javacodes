import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CarSpark{
    public static void main(String [] a){
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int i =0;i<test;i++) {
            int[] dp = new int [49];
            int n = scanner.nextInt();
            Node[] nod = new Node[n];
            for(int o= 0;o<n;o++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                int val = scanner.nextInt();
                nod[o] = new Node(start,end,val);
            }
            Arrays.sort(nod, new Comparator<Node>() {
                @Override
                public int compare(Node a, Node b) {
                    if(a.end==b.end) return a.start -b.start;
                    else{
                        return a.end-b.end;
                    }
                }
            });
            for(int k =0;k<n;k++){
                for(int j = nod[k].start;j>-1;j--){
                    dp[nod[k].end] = Math.max(dp[j]+nod[k].valu,dp[nod[k].end]);
                }
            }
            System.out.println(Arrays.toString(dp));
            int ans =0;

            for(int p=0;p<49;p++) {
                ans = Math.max(ans, dp[p]);
            }
            System.out.println(ans);



        }
    }
}

 class Node{
    int start;
    int end;
    int valu;
    public Node(int s,int e,int v){
        this.start=s;
        this.end=e;
        this.valu=v;
    }
}