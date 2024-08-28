import java.util.Scanner;
class BellmanFord{
    static int n;           // Total number of nodes
    static int[][] adj;     //  adjoin matrix containing edge weights
    static int[] cost;      //  how much distance from source node
    static int source;      // source node
    static int updated=0;   // costs updated in current iteration
    static int infinity=(int)Double.POSITIVE_INFINITY;  // infinite cost
    public static void findShortestPath(int src){
        updated = 0;    // reset flag
        for(int i=0;i<n;i++){
            if(adj[src][i]!=0) {
                if (adj[src][i] + cost[src] < cost[i]) {  //  relaxing
                    cost[i] = adj[src][i] + cost[src];
                    updated++;      //update flag
                }
            }
        }
        if(updated !=0) {   // stop if costs are not updated
            for (int i = 0; i < n; i++) {
                if (adj[src][i] != 0) {
                    findShortestPath(i);    // find all costs again
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of nodes in the graph: ");
        n = sc.nextInt();
        System.out.println("Enter adjacency matrix containing weight of edges: ");
        adj = new int[n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                adj[i][j] = sc.nextInt();
        cost = new int[n];
        for (int i=0;i<n;i++)
        {
            cost[i] =infinity; //  initialize each cost as infinity
        }
        System.out.println("Enter source vertex");
        source = sc.nextInt();
        source--;   //  decrementing source to have ease in indexing from 0
        cost[source]=0; //  cost of going from source to source is 0
        findShortestPath(source);  //  starting from source node
        for(int i=0;i<n;i++) {
            if(i!=source)
                System.out.println("\nShortest distance from source node "+(source+1)+" to node "+(i+1)+" is "+cost[i]);
        }
    }
}