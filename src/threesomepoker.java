import java.util.*;

/**
 * Created by smtt on 10/21/16.
 */
public class threesomepoker {
    public static void main(String [] args){
        Scanner scanner=new Scanner(System.in);
        int a = scanner.nextInt();
        int b=scanner.nextInt();
        int c =scanner.nextInt();
        tria newtree = new tria(a,b,c);
        newtree.createtree();
        node j = newtree.travarser();
        Stack<String> strings = new Stack<>();
        if(j!=null) {
            while (j.parent != null) {
//                System.out.println(j.p1 + " " + j.p2 + " " + j.p3);
                strings.push(j.p1 + " " + j.p2 + " " + j.p3);
                j=j.parent;
            }
            strings.push(j.p1 + " " + j.p2 + " " + j.p3);
//            (strings.size()<13)
            while (!strings.isEmpty()){
                System.out.println(strings.pop());
            }
        }
        else{
            System.out.println("Ok");
        }
    }

}
class tria{
    node root;
    int size=0;
    public tria(int a,int b,int c){
        root = new node(a,b,c,null);
    }
    Queue<node> stack = new LinkedList<node>();

    public void createtree(){
        stack.add(root);
        node pre=root;

        while(!stack.isEmpty() && size<13) {
            node root1 = stack.poll();
            if (root1 != null) {
                root1.createchild();
                if (root1.parent != pre.parent) {
                    size++;
                }
                stack.add(root1.left);
                stack.add(root1.middle);
                stack.add(root1.right);
                pre = root1;
            }
        }
    }
    Queue<node> tra = new LinkedList<node>();
    public node  travarser(){
        node root1 =root;
        tra.add(root1);
        while (!tra.isEmpty()){
            root1 = tra.poll();
            if(root1!=null) {
                if (root1.p1 != 0 && root1.p2 != 0 && root1.p3 != 0) {
                    tra.add(root1.left);
                    tra.add(root1.middle);
                    tra.add(root1.right);
                } else {
                    return root1;
                }
            }
        }
        return null;

    }

}

class node{
    int max;
    int midle;
    int min;
    int p1 ;
    int p2;
    int p3;
    node left;
    node middle;
    node right;
    node parent;
    public node(int p1,int p2,int p3,node parent){
        int [] ar = {p1,p2,p3};
        this.p1=p1;
        this.p2=p2;
        this.p3=p3;
        Arrays.sort(ar);
        max = ar[2];
        midle=ar[1];
        min=ar[0];
        this.parent =parent;
//        System.out.println(p1+" "+p2+" " +p3);
    }
    public void createchild() {
        if (min != 0 && midle != 0 && max != 0) {
            if(p1==min && p2 == midle ){
                left = new node(2 * min, midle - min, max,this);
                middle= new node(2 * min, midle, max - min,this);
                right = new node(min, midle * 2, max - midle,this);
            }
            else if(p1==min && p3==midle){
                middle= new node(2 * min, max,midle - min, this);
                left = new node(2 * min, max - min,midle, this);
                right = new node(min,  max - midle,midle * 2,this);
            }
            else if(p2 ==min && p1 == midle){
                right = new node( midle - min,2 * min, max,this);
                middle = new node(midle,2 * min, max - min,this);
                left= new node(midle * 2,min,  max - midle,this);
            }
            else if(p2 ==min && p1 == max){
                middle = new node(  max,2 * min,midle - min,this);
                left = new node(max - min,2 * min, midle,this);
                right = new node( max - midle,min,midle * 2,this);
            }
            else if(p3 ==min && p1 == midle){
                middle = new node( midle - min, max,2 * min,this);
                right = new node(midle,max - min,2 * min, this);
                left = new node(midle * 2,max - midle,min, this);
            }
            else if(p3 ==min && p1 == max){
                right = new node( max, midle - min,2 * min,this);
                middle = new node(max - min,midle,2 * min, this);
                left = new node(max - midle,midle * 2,min, this);
            }
        }
        else {
            return;
        }

    }
}