import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author acm
 */
class JavaApplication5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int intp=scan.nextInt();
        scan.nextLine();
        int window=scan.nextInt();
        scan.nextLine();
        String txt=scan.nextLine();
        String[] inp=txt.split(" ");
        int[] numbers=new int[inp.length];
        for (int i=0; i<inp.length; i++){
            numbers[i]=Integer.parseInt(inp[i]);
        }
        int[] fortot =new int[window];
        for (int i=0; i<window;i++){
            fortot[i]=0;
        }
        for (int s:numbers){
            swap(fortot,s);
            System.out.print(total(fortot)+" ");
        }


    }

    public static void swap(int[] aray,int no){
        for (int i=0;i<aray.length-2;i++){
            aray[i]=aray[i+1];
        }
        aray[aray.length-1]=no;
    }
    public static int total(int[] aray){
        int total=0;
        for(int no:aray){
            total+=no;

        }
        return total;
    }

}
