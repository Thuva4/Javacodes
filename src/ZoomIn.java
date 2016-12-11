import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Created by smtt on 10/18/16.
 */
public class ZoomIn {
    public static void main(String [] args){

            Scanner scanner = new Scanner(System.in);
            int colum = Integer.valueOf(scanner.nextLine());
            int row = scanner.nextInt();
            int chara = scanner.nextInt();
            Map<String, String[][]> aa = new HashMap<>();
//        try
//        {

            scanner.nextLine();

                //statements that may cause an exception
//            }
//            catch (Throwable  e)‏{
//                System.out.println("JAVA");
//            }



        for(int i =0 ; i<chara;i++){
            String j = scanner.nextLine();
            String[][] jj = new String[row][colum];
            for(int k =0 ;k<row; k++){
                jj[k] = scanner.nextLine().split("");
            }
            aa.put(j,jj);
        }

        int x = scanner.nextInt();
        scanner.nextLine();
        for(int o =0 ;o<x;o++){
            String [] strings = scanner.nextLine().split("");


            for(int i =0 ;i<row;i++){
                for(String s :strings){
                    for(String g : aa.get(s)[i]){
                        if(g.equals("")){
                            for(int t=0;t<colum;t++) {
                                System.out.print(" ");
                            }
                        }
                        System.out.print(g);
                    }
                }
                System.out.println();
            }
        }

    }
}

