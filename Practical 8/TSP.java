import java.util.Scanner;
public class TSP
{
    static int n;   //no. of nodes
    static int[][] adj; //cost matrix
    static int source;  //source node
    static int travel(int[] path, int src)
    {
        int[] minpath =new int[n+1];
        int[] newpath =new int[n+1];
        int mincost=Integer.MAX_VALUE;//initial minimum cost
        int ccost,dist;
        if(src == n)        // path cost for leaf node
            return adj[path[n]][source];
        for(int i=src+1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
                newpath[j] = path[j];
            newpath[src+1] = path[i];   //find new path combination
            newpath[i] = path[src+1];
            ccost=travel(newpath,src+1);//cost of current new path
            dist =adj[path[src]][path[i]];
            if((dist + ccost) < mincost)
            {
                mincost = dist + ccost; //update minimum cost
                for(int k=1; k<=n; k++) //store minimum cost path
                    minpath[k] = newpath[k];
            }
        }
        for(int i=1; i<=n; i++) //return minimum cost path
            path[i] = minpath[i];
        return mincost; // return minimum cost
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i, j,cost;
        System.out.print("Enter No. of Cities: ");
        n = sc.nextInt();
        adj =new int[n+1][n+1];
        int[] path =new int[n+1];
        System.out.println("Enter the Cost Matrix:");
        for(i=1;i<=n;i++)
            for(j=1;j<=n;j++)
                adj[i][j] = sc.nextInt();
        System.out.print("Enter head city: ");
        source = sc.nextInt();
        path[1]=source;     //arrange nodes from source
        for(i=2,j=1;i<=n;i++,j++) {
            if(j==source)
                j++;
            path[i]=j;
        }
        cost = travel(path, 1);
        System.out.print("Optimal rout: ");
        for(i=1;i<=n;i++)
            System.out.print(path[i]+" -> ");
        System.out.println(source);
        System.out.println("Minimum Cost: "+cost);
    }
}