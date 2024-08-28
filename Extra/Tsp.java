package Extra;

import java.util.*;
public class Tsp {
    static int [][] adj = {{0,10,15,20},{5,0,9,10},{6,13,0,12},{8,8,9,0}};
    static int source = 0;
    static Vector<Integer> arr = new Vector<>();

    public static int g(Integer src,Vector<Integer> set){
        Vector<Integer> path = new Vector<>();
        if(set.isEmpty()){
            System.out.println("from "+src+" to "+source+" = "+adj[src][source]);
            return adj[src][source];
        }
        if(set.size() == 1) {
            int k = set.get(0);
            System.out.println("source = " + src + " k= " + k);
            System.out.println(adj[src][k]+"\t"+adj[k][source]);
            return (adj[src][k]+adj[k][source]);
        }
        else {
            set.remove(src);
            for (int i : set) System.out.print(i + ", ");
            System.out.println();
            for (Integer k : set) {
                Vector<Integer> tempset = set;
                System.out.println("source = "+src+" k= " + k);
                tempset.remove(k);
                for (int i : tempset) System.out.print(i + ", ");
                System.out.println("\n" + adj[src][k] + "\n");
                path.add(adj[src][k] + g(k, tempset));
                System.out.println("\nlast element = " +path.lastElement()+ "\npath ");
            }
            for (int i : path) System.out.print(i+", ");
            return Collections.min(path);
        }
    }
    public static void main(String[] args) {
        arr.addAll(Arrays.asList(0,1,2,3));
        int answer = g(source,arr);
        System.out.println();
        System.out.println("\nanswer ="+answer);
    }
}