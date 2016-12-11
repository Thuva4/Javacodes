import java.io.*;
import java.util.*;

public class lazypleas{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int b = scan.nextInt();
        scan.nextLine();
        ArrayList<String> popularwords = new ArrayList<>();
        for(int i=0;i<n;i++){
            popularwords.add(scan.nextLine());
        }
        ArrayList<String> pleas = new ArrayList<>();
        for(int j=0;j<b;j++){
            pleas.add(scan.nextLine());
        }
        ArrayList<Integer> con = new ArrayList<>();
        for(String s:pleas){
            int total = 0;
            for(String k : popularwords){
                String [] sty = s.split(" ");
                for(String l:sty ) {
                    if (l.equals(k)) {
                        total++;
                    }
                }
            }
            con.add(total);
        }
        int max = Collections.max(con);
        System.out.println(pleas.get(con.indexOf(max)));
    }
}