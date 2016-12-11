/**
 * Created by smtt on 11/13/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GenericTreeNode<T> {

    public T data;
    public List<GenericTreeNode<T>> children;

    public GenericTreeNode() {
        super();
        children = new ArrayList<GenericTreeNode<T>>();
    }

    public GenericTreeNode(T data) {
        this();
        setData(data);
    }

    public List<GenericTreeNode<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return (getNumberOfChildren() > 0);
    }

    public void setChildren(List<GenericTreeNode<T>> children) {
        this.children = children;
    }

    public void addChild(GenericTreeNode<T> child) {
        children.add(child);
    }

    public void addChildAt(int index, GenericTreeNode<T> child) throws IndexOutOfBoundsException {
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList<GenericTreeNode<T>>();
    }

    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public GenericTreeNode<T> getChildAt(int index) throws IndexOutOfBoundsException {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return getData().toString();
    }

    public boolean equals(GenericTreeNode<T> node) {
        return node.getData().equals(getData());
    }

    public int hashCode() {
        return getData().hashCode();
    }

    public String toStringVerbose() {
        String stringRepresentation = getData().toString() + ":[";

        for (GenericTreeNode<T> node : getChildren()) {
            stringRepresentation += node.getData().toString() + ", ";
        }

        //Pattern.DOTALL causes ^ and $ to match. Otherwise it won't. It's retarded.
        Pattern pattern = Pattern.compile(", $", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(stringRepresentation);

        stringRepresentation = matcher.replaceFirst("");
        stringRepresentation += "]";

        return stringRepresentation;
    }
}


public class generictree{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        HashMap<Integer, Node1>  map = new HashMap<>();
        int [] list = new int[n];
        for(int i=0;i<n;i++){
            list[i] = scanner.nextInt();
            map.put(i+1 ,new Node1(i+1,list[i]) );
        }

        for(int i=0;i<n-1;i++){
            int j = scanner.nextInt();
            int l = scanner.nextInt();
            map.get(j).addneibour(map.get(l));
        }
        for(int i=0;i<k;i++){
            int j = scanner.nextInt();
            int l= scanner.nextInt();
            int m = scanner.nextInt();
            int o = scanner.nextInt();


        }



    }
}
class Node1{
    int id;
    int value;
    ArrayList<Node1> list = new ArrayList<>();
    public  Node1(int i,int v){
        this.id=i;
        this.value = v;
    }
    public void addneibour(Node1 n){
        list.add(n);
        n.list.add(this);
    }

//    ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> travel(Node1 i , Node1 j,ArrayList<Integer> arrayList){
      return arrayList;
    }


}