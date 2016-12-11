import java.util.*;

/**
 * Created by smtt on 10/2/16.
 */
public class solution5 {
    public static void main(String [] args){
        double[] j = new double[4];
        j[0]=10;
        j[1]=11;
        j[2]=9;
        j[3]=1;
//        double [] jj =
        double lat =18.9778972;
        double sub_lat=18.97523123;
        double lon=72.8321983;
        double sub_lon = 72.83494895;
        double h = 2 * 6378.137 * Math.asin(Math.sqrt(Math.pow(Math.sin((lat - sub_lat)/2), 2) + Math.cos(lat) * Math.cos(sub_lat) * Math.pow(Math.sin((lon - sub_lon) / 2),2)));
       System.out.println(h);
//        System.out.println(distance(lat,lon,sub_lat,sub_lon));
    }


//    private static double distance(double lat1, double lon1, double lat2, double lon2) {
//        double theta = lon1 - lon2;
//        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
//        dist = Math.acos(dist);
//        dist = rad2deg(dist);
//        dist = dist * 60 * 1.1515;
//    }
//
//    private static double deg2rad(double deg) {
//        return (deg * Math.PI / 180.0);
//    }
//
//    private static double rad2deg(double rad) {
//        return (rad * 180.0 / Math.PI);
//    }
    }

