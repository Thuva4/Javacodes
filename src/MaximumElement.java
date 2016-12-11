import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by smtt on 10/10/16.
 */
public class MaximumElement {
    public static void main(String [] a){
        Stack<Integer> stack = new Stack<>();
        Scanner scanner =new Scanner(System.in);
        Stack<Integer> largest_stack = new Stack<>();

        int n = scanner.nextInt();
//        List<Integer> la = new ArrayQueue<>(n);
        largest_stack.push(0);
        scanner.nextLine();
        for(int i=0;i<n;i++){
            String [] s = scanner.nextLine().split(" ");
            if(Integer.parseInt(s[0])==1){
                if(largest_stack.peek()<=Integer.parseInt(s[1])){
                    largest_stack.push(Integer.parseInt(s[1]));
                }
                stack.push(Integer.parseInt(s[1]));
            }
            else if(Integer.parseInt(s[0])==2){
                int j = stack.pop();
                if(j==largest_stack.peek()){
                    largest_stack.pop();
                }
            }
            else if(Integer.parseInt(s[0])==3){
                System.out.println(largest_stack.peek());
            }
        }
    }
}
