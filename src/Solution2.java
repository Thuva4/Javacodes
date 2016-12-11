import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by smtt on 10/2/16.
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner text = new Scanner(System.in);
        int n = text.nextInt();
        text.nextLine();
        ArrayList<String> inp = new ArrayList();
        ArrayList<String> in = new ArrayList();
        for (int i = 0; i < n; i++) {
            String s = text.nextLine().split(" ")[0];
            inp.add(s + " " + text.nextLine());
        }
        for (String s : inp) {
            String[] row = s.split(" ");
            ArrayList<String> no = new ArrayList();
            for (int i = 0; i < row[0].length(); i++) {
                no.add(row[0].substring(i, i + 1));
            }
//            System.out.println(no);
            int base=Integer.parseInt(row[1]);
            BigInteger temp=new BigInteger("0");
            for(int i=0;i<no.size();i++){
                BigInteger number1= new BigInteger(no.get(i));
                BigInteger number2;
                if(base>0) {
                    number2 = new BigDecimal(base * Math.pow(base, no.size() - i - 2)).toBigInteger();
                    temp=temp.add(number1.multiply(number2));
//                    System.out.println(temp);
                }
                else{
                    temp = new BigInteger(no.get(no.size()-1));
                    return;

                }
                //


            }
            BigInteger number3=new BigInteger(row[2]);


                System.out.println(temp.mod(number3));


        }

    }

}