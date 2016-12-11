import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class dogwalking {
    public static void main(String[] args) {
        int []set ={1,1,2,3};
        System.out.print(partition(set,0,set.length-1));
//        ArrayList<> h = new ArrayList();
//        h.
    }


    static String partition(int s[], int db, int fn) {
        int n = (fn - db) + 1;
        String res = "";
        if (n <= 2) {
            res += "[";
            for (int l = db; l <= fn; l++) res += s[l];
            res += "]";
            return res;
        }
        int[][] m = new int[n + 1][3];                 /* DP table for values */
        int[][] d = new int[n + 1][3];                 /* DP table for dividers */
        int[] p = new int[n + 1];                    /* prefix sums array */
        int cost;                               /* test split cost */
        int i, x = 0;                              /* counters */

        p[0] = 0;                               /* construct prefix sums */
        for (i = 1; i <= n; i++)
            p[i] = p[i - 1] + s[(db - 1) + i];

        for (i = 1; i <= n; i++)
            m[i][1] = p[i];    /* initialize boundaries */
        m[1][2] = s[db];


        for (i = 2; i <= n; i++) {                    /* evaluate main recurrence */
            m[i][2] = Integer.MAX_VALUE;
            for (x = 1; x <= (i - 1); x++) {
                cost = Math.max(m[x][1], p[i] - p[x]);
                if (m[i][2] > cost) {
                    m[i][2] = cost;
                    d[i][2] = db + (x - 1);
                }
            }
        }
        return res += "[" + partition(s, db, d[n][2]) + partition(s, d[n][2] + 1, fn) + "]";

    }
}
