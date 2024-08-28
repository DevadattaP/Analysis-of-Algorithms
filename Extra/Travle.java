package Extra;
import java.util.*;
public class Travle {
    static int[][] adj;
    static int n;
    static int[] visited;
    static int source;
    static Set<Integer> path = new HashSet<>();
    public static int travel(Set<Integer> set,int src){
        Set<Integer> temp = new HashSet<>();
        System.out.println("\n"+src);
        for(int i:set)
            System.out.println(i);
        visited[src] = 1;
        if(set.size() == 2){
            set.remove(src);
            int k = 0;
            for(int i :set)
                k=i;
            return adj[src][k];
        }
        else{
            for(int j:set){
                for(int i:set){
                    if(visited[i]==0){
                        if(j!=i && j!=src){
                            Set<Integer> newset=set;
                            newset.remove(i);
                            temp.add(travel(newset,j)+adj[j][i]);
                            visited[j]=1;
                        }
                    }
                }
            }
            return Collections.min(temp);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of cities: ");
        n= sc.nextInt();
        adj = new int[n][n];
        visited = new int[n];
        System.out.println("Enter cost matrix: ");
        for(int i=0;i<n;i++)
            path.add(i);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adj[i][j]=sc.nextInt();
            }
            visited[i]=0;
        }
        System.out.println("\nEnter source node: ");
        source = sc.nextInt();
        int cost = travel(path,source);
        System.out.println(cost);
    }
}
