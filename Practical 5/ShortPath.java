import java.util.Scanner;
class ShortPath{
    static int n;           // total number of nodes
    static int[][] adj;     //  adjoin matrix containing edge weights
    static int[] cost;      //  how much distance from source node
    static int[] visited;   //  1 if visited , 0 otherwise
    static int source;
    static int total_visited=0;
    static int infinity=(int)Double.POSITIVE_INFINITY;
    public static void findShortPath(int src){
        if(visited[src] == 0){  //  proceed if node is unvisited
            System.out.println("\n\tVisiting Node "+(src+1));                   //  Formatting
            System.out.println("Node\tVisited?\tCost\t\tMinimum\t\tMinIndex");  //  the output
            visited[src]=1;     //  mark visited
            total_visited++;    //  update total number of visited nodes
            int minIndex=infinity,min=infinity;
            for(int i=0;i<n;i++){
                if(visited[i]==0 && adj[src][i]!=0) {
                    if (adj[src][i] + cost[src] < cost[i])  //  relaxing
                        cost[i] = adj[src][i] + cost[src];
                }
                if (visited[i] != 1) {  //  finding minimum cost to visit node i
                    if (cost[i] != 0 && cost[i] < min) {
                        min = cost[i];
                        minIndex = i;
                    }
                }
                System.out.print(i+1+"\t\t"+visited[i] + "\t\t\t"); //  F
                if(cost[i]==infinity)                               //  O
                    System.out.print("INF" + "\t\t\t");             //  R
                else                                                //  M
                    System.out.print(cost[i] + "\t\t\t");           //  A
                if(min==infinity)                                   //  T
                    System.out.print("INF" + "\t\t\t");             //  T
                else                                                //  I
                    System.out.print(min + "\t\t\t");               //  N
                if(minIndex==infinity)                              //  G
                    System.out.println("INF");                      //
                else                                                //  O/P
                    System.out.println(minIndex);                   //
            }
            if(total_visited!=n)
                findShortPath(minIndex);    //  select min cost node and find remaining paths
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
        visited = new int[n];
        cost = new int[n];
        for (int i=0;i<n;i++)
        {
            cost[i] =infinity; //  initialize each cost as infinity
            visited[i] = 0;                         //  mark all unvisited
        }
        System.out.println("Enter source vertex");
        source = sc.nextInt();
        source--;   //  decrementing source to have ease in indexing from 0
        cost[source]=0; //  cost of going from source to source is 0
        for(int i=0;i<n;i++){
            if(adj[source][i]!=0){
                cost[i]=adj[source][i]; //  updating cost of adjacent ages to source node
            }
        }
        findShortPath(source);  //  starting from source node
        for(int i=0;i<n;i++) {
            if(i!=source)
                System.out.println("\n Shortest distance from source node "+(source+1)+" to node "+(i+1)+" is "+cost[i]);
        }
    }
}