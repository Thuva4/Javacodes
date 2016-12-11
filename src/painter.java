import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by smtt on 10/22/16.
 */
public class painter {
    public static void main(String [] args){
        Scanner scanner= new Scanner(System.in);
        int test = scanner.nextInt();
        for(int i=0;i<test;i++){
            int size = scanner.nextInt();
            int[] walls =new int[size];
//            int[][] dp = new int[size + 1][size + 1];
            int a=0;
            int b =0;
            Map<Integer,Integer> map = new HashMap<>();
            for(int j =0;j<size;j++){
                walls[j]=scanner.nextInt();
                if(map.get(walls[j])==null){
                    map.put(walls[j],1);
                }
                else{
                    map.put(walls[j],map.get(walls[j])+1);
                }
            }
            int total=1;
            a=walls[0];
            b=0;
            map.put(walls[0],map.get(walls[0])-1);
            int current=a;
            int pre = a;
            for(int j =1;j<size;j++){
                map.put(walls[j],map.get(walls[j])-1);
                pre =current;
                if(walls[j]!=a){
                    if(b==0){
                        b=walls[j];
                        current=b;
                    }
                    else if(walls[j]!=b){
//                        map.put(walls[j], map.get(walls[j]) - 1);
                        if(map.get(a)<map.get(b)){
                            a = walls[j];
                            current =a;
//                            map.put(a, map.get(a) - 1);
                        }
                        else {
                            b = walls[j];
                            current=b;
//                            map.put(b, map.get(b) - 1);
                        }
                    }

                }
                if(pre!=current){
                    total++;
                }
            }
//            System.out.println(Arrays.deepToString(dp));
            System.out.println(total);


        }
    }
}
