//public class Permute{
//    static void permute(java.util.List<Integer> arr, int k){
//        int total = 0;
//        for(int i = k; i < arr.size(); i++){
////            java.util.Collections.swap(arr, i, k);
//            permute(arr, k+1);
//            java.util.Collections.swap(arr, k, i);
//            System.out.println(arr);
//            int R =0;
//            int L=0;
//            Boolean left = true;
//            Boolean right = true;
//            int j =0;
//            while(left&& j<arr.size()-1){
//                if(arr.get(j)<=arr.get(j+1)){
//                    L++;
//                }
//                else {
//                    left=false;
//                }
//
//            }
//            j =0;
//            while(right&& j>0){
//                if(arr.get(j-1)<=arr.get(j)){
//                    L++;
//                }
//                else {
//                    right=false;
//                }
//
//            }
//            if(R==2 && L ==2 ){
//                total++;
//            }
//
//        }
//        System.out.println(total);
//        if (k == arr.size() -1){
////            System.out.println(java.util.Arrays.toString(arr.toArray()));
//        }
//    }
//    public static void main(String[] args){
//        jjjjj.permute(java.util.Arrays.asList(4,3,2,1), 0);
//    }
//}
