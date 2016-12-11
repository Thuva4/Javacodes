

import java.util.Arrays;
import java.util.List;

/**
 * Created by smtt on 9/29/16.
 */
public class Practice {
    public static void main(String [] args){
        System.out.println("thuva");
        String s ="sshshshssh";
        String temp = s;
        Boolean condition = true;
        while (condition){


            String temp1 = temp;
            temp = temp.replaceAll("ss", "h");
            temp = temp.replaceAll("hh", "s");
            if(temp1.equals(temp)){
                condition = false;
            }
            System.out.println(temp);
        }


    }
}
