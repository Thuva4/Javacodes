import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4
{

    static int getMinSquares(int n)
    {

        int intArray[] = new int[n+1];
        intArray[0] = 0;
        intArray[1] = 1;
        intArray[2] = 2;
        intArray[3] = 3;


        for (int i = 4; i <= n; i++)
        {
            intArray[i] = i;

            for (int x = 1; x <= i; x++) {
                int temp = x*x;
                System.out.println(Arrays.toString(intArray));
//                System.out.println(i-temp);
                if (temp > i)
                    break;
                else intArray[i] = Math.min(intArray[i], 1+intArray[i-temp]);
            }
        }


        int res = intArray[n];

        return res;
    }


    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
//        System.out.println(n);
//        int [] array = new int[n];
        ArrayList<Integer> array = new ArrayList<>();
        for(int i =0;i<n;i++) {
            array.add(scan.nextInt());
//            System.out.println(array);
        }
        for(int j:array){
            System.out.println(getMinSquares(j));
        }
    }
}
