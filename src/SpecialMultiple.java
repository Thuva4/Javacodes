import java.util.Scanner;

/**
 * Created by smtt on 10/24/16.
 */
public class SpecialMultiple {
    public static void main(String [] args){
        String [] array= {"9","0"};
        Scanner scanner = new Scanner(System.in);
        int test= scanner.nextInt();
        for(int i=0;i<test;i++){
            int n=scanner.nextInt();
            boolean cond = true;
            int j=0;
            String s="9";
            String pre = s;
            while(cond){

                if(Long.parseLong(s)%n==0){
                    cond = false;
                    break;
                }
                else{
                    if(j==0){
                        s=pre;
                        j++;
                    }
                    else {
                        j=0;
                    }
                }
                pre=s;
                s+=array[j];

            }
            System.out.println(s);
        }
    }
}
