import java.util.Scanner;
import java.util.Stack;

/**
 * Created by smtt on 10/11/16.
 */
public class SockMerchant {
    public static void main(String [] a){
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> sock_stack = new Stack<>();
        int n = scanner.nextInt();
        for(int i=0;i<n;i++){
            sock_stack.push(scanner.nextInt());
        }
        int total =0;
        while(!sock_stack.isEmpty()){
            int current = sock_stack.pop();
//            Stack<Integer> nnnn = sock_stack;
            for(int k : sock_stack){
                if(current==k){
                    int indx = sock_stack.indexOf(k);
                    sock_stack.remove(indx);
                    total++;
                    break;
                }
            }
        }
        System.out.println(total);

    }
}
