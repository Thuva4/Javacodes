//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//
//class Solution{
//    public static void main(String [] args){
//        Scanner scan = new Scanner(System.in);
//        int n = Integer.parseInt(scan.nextLine());
//        ArrayList<String> first = new ArrayList<>();
//        for(int i=0;i<n;i++){
//            String str = scan.nextLine();
//            first.add(str);
//        }
//        for(String s : first){
//            String s1 = sushing(s);
//            System.out.println(s1);
//        }
//    }
//
//    public static String sushing(String s) {
//        String[] second = s.split("");
////        ArrayList<String> third = new ArrayList<>(Arrays.asList(second));
//        String temp = "";
//
//        for (int i = 0; i < s.length()-2; i = i + 2) {
//
//            if (second[i].equals(second[i + 1])) {
//
//                if (second[i].equals("s")) {
//                    temp += "h";
//                }
//                if (second[i].equals("h")) {
//                    temp += "s";
//                }
//            }
//            else {
//                temp =temp+second[i] +second[i+1];
//////                if(s.length()%2!=0 && i==s.length()-1-2){
//////                    temp = temp + second[i+2];
//////                }
//            }
//            System.out.println(temp);
//            if (temp.length()>1) {
//                sushing(temp);
//            }
//
//        }
//        return temp;
//    }
//}
