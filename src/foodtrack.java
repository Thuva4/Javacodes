import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class foodtrack {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] d_arr = scan.nextLine().split(",");
//        System.out.println("####");
        double lat = Double.parseDouble(d_arr[0]);
        double lon = Double.parseDouble(d_arr[1]);
//        System.out.println(d_arr[0]);
        double dis = scan.nextDouble();
        String[] arr = new String[4];
        scan.nextLine();
        ArrayList list = new ArrayList();
        ArrayList list1 = new ArrayList();
        arr = scan.nextLine().split(",");
        int lat_ind = Arrays.asList(arr).indexOf("Latitude");
        int lon_ind = Arrays.asList(arr).indexOf("Longitude");
        int pn = Arrays.asList(arr).indexOf("PhoneNumber");
//        System.out.println("####");
//        String str = scan.nextLine();
        int inse =0;
        while (scan.hasNextLine()) {
            String[] sub_arr = new String[4];
//            System.out.println("!!!!");
            sub_arr = scan.nextLine().split(",");
            double sub_lat = Double.parseDouble(sub_arr[lat_ind]);
            double sub_lon = Double.parseDouble(sub_arr[lon_ind]);
            long sub_pn = Long.parseLong(sub_arr[pn]);
            double ac_dist = distance(lat,lon,sub_lat,sub_lon);
//            System.out.println(ac_dist);
            if (ac_dist<= dis) {
                if (list.contains(sub_pn)) {
                    continue;
                } else {
                    list.add(sub_pn);
                }
            } else {
                if (list.contains(sub_pn)) {
                    list.remove(list.indexOf(sub_pn));
                }
            }

            inse++;
        }
        Collections.sort(list);
        for(int j =0;j<list.size();j++) {
            if(j==list.size()-1){
                System.out.print(list.get(j));
            }
            else{
                System.out.print(list.get(j) + ",");
            }

        }

    }

    private static double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}