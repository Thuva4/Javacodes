import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.StreamSupport;

import static java.lang.Math.PI;

/**
 * Created by smtt on 10/23/16.
 */
public class ellipes {
    public static void main(String [] srg){
        double x1=-50.0;
        double x2 = 50.0;
        double y1=-50.0;
        double y2 = 50.0;
        int area = 10000;
        Scanner scanner=new Scanner(System.in);
        int test = scanner.nextInt();
        for(int i=0;i<test;i++){
            int x=scanner.nextInt();
            int [][] graph=new int[100][100];
            double ac_area=0;
            for(int j=0;j<x;j++){
                int fx1 = scanner.nextInt();
                int fy1 = scanner.nextInt();
                int fx2 = scanner.nextInt();
                int fy2 = scanner.nextInt();
                double area_ratio=0;

                int a = scanner.nextInt();
//                System.out.println(a);
                int centre_x=(fx2+fx1)/2;
//                System.out.println(centre_x);
                int centre_y=(fy2+fy1)/2;
//                System.out.println(centre_y);
                double c = Math.sqrt(Math.pow(centre_x-fx1,2) + Math.pow(centre_y-fy1,2));
//                System.out.println(c);
                double b = Math.sqrt(Math.pow(a/2,2)-Math.pow(c,2));
//                System.out.println(b);
                if(centre_x+b<=50 && centre_x-b>=-50){
                    if(centre_y+(a/2)<=50 && centre_y-(a/2)>=-50){
                        area_ratio=1;
                    }
                    else {
                        area_ratio=0.5;
                    }
                }
                else if(centre_y+(a/2)<=50 && centre_y-(a/2)>=-50 ){
                     if(centre_x+b<=50 || centre_x-b>=-50) {
                         area_ratio = 0.5;
                     }
                }
                else if(centre_x+b>50 && centre_x-b<-50 && centre_y+(a/2)>50 && centre_y-(a/2)<-50){
                    area_ratio=0;
                }
                else {
                    area_ratio=0.25;
                }

                for (double t = 0; t < 2 * PI; t += 1) { // <- or different step
                    int x3 = (int)b * (int )Math.cos(t);
                    int y3 = (int )a/2 * (int)Math.sin(t);

                    if(x3<100 && y3<100){
                        graph[(int)y3][(int)x3]=1;
                    }
                }
                ac_area += PI *a/2 *b*area_ratio;
                for(int h =0;h<100;h++) {
                    System.out.println(Arrays.toString(graph[h]));
                }
            }
            double ratio = ((area-ac_area)/area)*100;
//            System.out.println(ac_area);
            System.out.println(Math.round(ratio)+"%");
        }


    }
}
