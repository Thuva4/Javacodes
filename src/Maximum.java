import java.util.*;

/**
 * Created by smtt on 10/3/16.
 */
public class Maximum {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int k =scan.nextInt();
        Long b=scan.nextLong();
        ArrayList<Integer> maxTotal = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =(int)(b/2);i<b;i++){
           maxTotal.add(functionMax(i,k,b,map));
        }
        int max = Collections.max(maxTotal);
        System.out.println(maxTotal.indexOf(max)+b/2);
//        System.out.println(maxTotal.get((int)(b-5-1)));

    }

    public static int functionMax(int i,int k,Long n,Map map){
        if(0<=i && i<k){
            map.putIfAbsent(i,i);
//            System.out.print(i);
            return i;
        }
        else if (0<i && i%k==0){
            if(map.get(i/k)!=null){
                return (int) map.get(i/k);
            }
            else{
                int p =functionMax(i/k,k,n,map);
                map.put(i/k,p);
            }
            System.out.println(map.keySet());
            return (int) map.get(i/k);
        }
        else{
            int r = i%k;
            if(map.get(i-r)!=null){
                return (int) map.get(i-r)+r;
            }
            else{
                int p =functionMax(i-r,k,n,map);
                map.put(i-r,p);
            }
            System.out.println(map.keySet());
            return (int) map.get(i-r) + r;
        }

    }
}
