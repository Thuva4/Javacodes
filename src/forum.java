import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by smtt on 10/22/16.
 */
public class forum {
    static int t=0;
    public static void main(String [] s){
//
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                int a =0;
                int p=0;
                try {
                a = scanner.nextInt();
                p = scanner.nextInt();
            }
        catch (Exception e){
           break;
        }
                ArrayList<post> threadlist = new ArrayList<>();
                ArrayList<post> reply_list = new ArrayList<>();
                ArrayList<post> post_list = new ArrayList<>();
                for (int i = 0; i < p; i++) {
                    int x = scanner.nextInt();
                    if (x == 0) {
                        post temp = new post(i);
                        threadlist.add(temp);
                        post_list.add(temp);
                    } else {
                        post temp = new post(i);
                        reply_list.add(temp);
                        post_list.add(temp);
                        post_list.get(x - 1).addnew(temp);

                    }

                }
                int max = 0;
                int i=0;
                int [] thread = new int[threadlist.size()];
                for (post j : threadlist) {

                    t++;
                    t = travers(j, t);

                    thread[i]=t;
                    i++;
                    max=0;
                    t=0;

                }
//                System.out.println(Arrays.toString(thread));
                int post=0;
                int n=0;
                int o=0;
                int totalP=0;
                while(o<thread.length && totalP<p){
                    post+=thread[o];
                    if(post==a+n){
                        o++;
                        totalP=post;
                        post=0;
                    }
                    else if(post>a+n){
                        o=0;
                        n++;
                        post=0;
                    }

//                    System.out.println(totalP);


                }
              System.out.println(n);

            }


    }

    static int travers(post o,int t){
        if(o.array.size()>0){
//            System.out.println(o.id);
            for(post p:o.array){
                t++;
                t=travers(p,t);
//                System.out.println(t);
            }
        }
        return t;
    }


}
class post{
    ArrayList<post> array = new ArrayList<>();
    int id ;
    post(int id){
        this.id=id;

    }

    public void addnew(post a){
        array.add(a);
    }
}