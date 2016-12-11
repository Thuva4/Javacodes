import java.util.*;


public class summa {
    public static void main(String [] s){
        Scanner scan = new Scanner(System.in);
        int k =scan.nextInt();
        Long b=scan.nextLong();
        ArrayList<Integer> maxTotal = new ArrayList<>();
        int j =1;
        if(b%k==0){
            System.out.println(b-1);
        }
        else {
            for (int i = k; i < b; i = i + k) {
                maxTotal.add(functionMax(i - 1, k, b));
                j++;
            }
            int max = Collections.max(maxTotal);
//        System.out.println(maxTotal);
            System.out.println(((maxTotal.indexOf(max) + 1) * k) - 1);
        }
    }
    public static int functionMax(int i,int k,Long n){
        if(0<=i && i<k){

            return i;
        }
        else if (0<i && i%k==0){
                return functionMax(i/k,k,n);
//            Queue<Integer> queue = new Queue<>();
        }
        else{
            int r = i%k;
                return functionMax(i-r,k,n)+r;
        }
    }
}
