import java.util.Scanner;

/**
 * Created by smtt on 10/22/16.
 */
public class CountingMolecules {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        double c = scanner.nextDouble();
        double h = scanner.nextDouble();
        double o = scanner.nextDouble();

        double y = (2*o-h)/4;
        double z=(c-y)/6;
        double x=(h-12*z)/2;
        if(y-(int)y>0 || z-(int)z>0||y-(int)y>0){
            System.out.println("Error");
        }
        else {
            System.out.println((int) x + " " + (int) y + " " + (int) z);
        }
    }
}
