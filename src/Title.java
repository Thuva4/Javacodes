import java.util.ArrayList;
import java.util.Scanner;


public class Title {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int d=0; d<t ;d++){
            int p =scan.nextInt();
            ArrayList<Integer> pp= new ArrayList<>();
            ArrayList<Integer> left= new ArrayList<>();
            ArrayList<Integer> right= new ArrayList<>();
            for (int i =0; i<p;i++){
                pp.add(scan.nextInt());
            }
            if (pp.size()<2){
                System.out.println(pp.size());
            }
            else {
                if (pp.get(0)>pp.get(1)){
                    left.add(pp.get(0));
                    right.add(pp.get(1));
                }
                else {
                    left.add(pp.get(1));
                    right.add(pp.get(0));
                }
                for (int i=1;i<pp.size()-1;i++){
                    if(left.size()+right.size()<20) {
                        if (pp.get(i + 1) >= left.get(left.size() - 1)) {
                            left.add(pp.get(i + 1));
                        } else if (pp.get(i + 1) <= right.get(right.size() - 1)) {
                            right.add(pp.get(i + 1));
                        }
                    }
                }
                System.out.println(left.size()+right.size());
            }}

    }}