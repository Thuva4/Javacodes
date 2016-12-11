import java.util.*;

/**
 * Created by smtt on 11/4/16.
 */
public class BreadthFirstSearch {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        Map<Integer, tree> dict = new HashMap<>();
        Map<Integer,Integer> length = new HashMap<>();
        for(int i=0;i<test;i++){
            int nodes = scanner.nextInt();
            int paths = scanner.nextInt();
//            System.out.println(nodes + " " +paths);
            for(int j=1;j<=nodes;j++){
                dict.put(j,new tree(dict.get(j-1)));
                if(j>1) {
                    length.put(j, -1);
                }
            }
//            System.out.println(dict.keySet());
            for(int j=0;j<paths;j++){
                int parent = scanner.nextInt();
                int child = scanner.nextInt();
                dict.get(parent).child.add(dict.get(child));

            }
            int rootn = scanner.nextInt();
            tree root = dict.get(rootn);
//            System.out.println(root.child);
            for(int j=1;j<=nodes;j++) {
                if (j != rootn) {
//                    System.out.println(root.child);
                    Queue<tree> queue = new LinkedList();
                    if (root.child.contains(dict.get(j))) {
                        System.out.print(6 +" ");
                    } else {
                        queue.addAll(root.child);
                        int l = queue.size();
                        int tot = 12;
                        boolean con = false;
                        while (!queue.isEmpty()) {
                            tree root1 = queue.poll();
                            l = l - 1;

                            if (root1.child.contains(dict.get(j))) {
                                System.out.print(tot+" ");
                                con = true;
                            } else {
                                queue.addAll(root1.child);
                                if (l == 0) {
                                    l = queue.size();
                                    tot += 6;
                                }
                            }

                        }
                        if (!con) {
                            System.out.print(-1 +" ");
                        }

                    }

                }
            }
            System.out.println();
        }
    }
}

class tree{
    ArrayList<tree> child = new ArrayList<>();
    tree parent = null;

    public tree(tree parent){
        this.parent = parent;
    }
    public void setChild(tree child){
        this.child.add(child);
    }
}
