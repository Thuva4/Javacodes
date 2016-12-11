import java.util.Scanner;

/**
 * Created by smtt on 10/19/16.
 */
public class JohnSubwayCommute {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String [] seats = scanner.nextLine().split("");
        int n = seats.length;
        if(seats[n-1].equals("E")){
            System.out.println(n-1);
        }
        else if(seats[0].equals("E")){
            System.out.println(0);

        }
        else{
            for(int i =1;i<n-2 ;i++){
                if(seats[i].equals("E") &&seats[i+1].equals("E") && seats[i+2].equals("E")){
                    System.out.println(i+1);
                }
                else {
                    System.out.println(i);
                }

            }
        }
    }
}
