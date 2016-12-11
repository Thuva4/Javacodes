import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class aaaa {
    private static int printPermutationsIterative(String string,int l,int r) {
        int[] factorials = new int[string.length() + 1];
        factorials[0] = 1;
        for (int i = 1; i <= string.length(); i++) {
            factorials[i] = factorials[i - 1] * i;
        }
        int total =0;
        for (int i = 0; i < factorials[string.length()]; i++) {
            String onePermutation = "";
            String temp = string;
            int positionCode = i;

            for (int position = string.length(); position > 0; position--) {
                int selected = positionCode / factorials[position - 1];
                onePermutation += temp.charAt(selected);
                positionCode = positionCode % factorials[position - 1];
                temp = temp.substring(0, selected) + temp.substring(selected + 1);
            }
//           System.out.println(onePermutation);
            String [] str = onePermutation.split("");
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j=0;j<onePermutation.length();j++){
                arr.add(Integer.parseInt(str[j]));
            }
//            System.out.println(arr);
            int R =1;
            int L=1;
            Integer max = Collections.max(arr);
            Boolean left = true;
            Boolean right = true;
            int j =1;
            int k =0;
            while(left && j<=arr.size()-1){
                if(arr.get(k)<=arr.get(j)){
                    L++;
                    k=j;
                    j++;
//                    System.out.println(i);
                }
                else {
                    if(arr.get(j)==max) {
                        left = false;
//                        System.out.println("KKK");

                    }
                    j++;
                }
//            j++;
            }

            j =arr.size()-2;
            k = arr.size()-1;
            while(right && j>=0 && k>0){
                if(arr.get(j)>=arr.get(k)){
                    R++;
                    k=j;
                    j--;



                }

                else {
                if(arr.get(j)==max) {
                    right=false;
                }
                j--;
                }

            }

//            System.out.println(L +"      "+R);
            if(R==r && L ==l ){
                total++;
            }
        }
        return total;
    }


    public static void main(String[] a){
        Scanner scan = new Scanner(System.in);
        int n =scan.nextInt();
        scan.nextLine();
        ArrayList<String> stringArrayList = new ArrayList<>();
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(int i =0;i<n;i++){
            int k = scan.nextInt();
            int l = scan.nextInt();
            int r = scan.nextInt();
            String tem ="";
            for(int j =1; j<=k;j++){
                tem+=Integer.toString(j);
            }
            stringArrayList.add(tem);

            integerArrayList.add(printPermutationsIterative(tem,l,r));

        }
//        System.out.println(stringArrayList);
        for(int g : integerArrayList) {
            System.out.println(g);

        }
    }
}