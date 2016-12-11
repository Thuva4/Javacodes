//import java.util.*;
//
///**
// * Created by smtt on 10/11/16.
// */
//public class NonDivisibleSubset {
//    public static void main(String [] a){
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int k = scanner.nextInt();
//        Long [] aa= new Long[n];
//        for(int i=0;i<n;i++){
//            aa[i]=scanner.nextLong();
//        }
//        Map<Long,Integer> aaa = new HashMap<>();
//
//        for(Long j:aa){
//            List<Long> ap = Arrays.asList(aa);
////            int index = ap.indexOf(j);
////            ap.remove(index);
//
//            for(Long p : ap){
//                if(p!=j) {
//                    if ((j + p) % k != 0) {
//                        System.out.println(j + " " + p) ;
//                        System.out.println(j+p);
//                        System.out.println((j+p)%k);
//                        aaa.putIfAbsent(j, 1);
//                        aaa.putIfAbsent(p, 1);
//                    }
//                }
//            }
//        }
//        System.out.println(aaa.keySet());
//        System.out.println(aaa.keySet().size());
//
//    }
//}