package test;
import java.util.Scanner;
public class TSP
{
    static int n;
    static int[][] adj;
    static int source;
    static int[] finalpath =new int[n+1];
    static int[] path;
    static int travel(int src)
    {
        int mincost = Integer.MAX_VALUE;
        int ccost = 0;
        if(src==n)
            mincost = adj[src][source];
        else{
            ccost = travel(1);
            mincost = Math.min(mincost,ccost);
        }
        return mincost;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter No. of Cities: ");
        n = sc.nextInt();
        adj =new int[n+1][n+1];
        path =new int[n+1];
        System.out.println("Enter the Cost Matrix:");
        for(int i=1;i<=n;i++)
            for(int j=1;j<=n;j++)
                adj[i][j] = sc.nextInt();
        System.out.print("Enter source node: ");
        source = sc.nextInt();
        path[1]=source;
        for(int i=2,j=1;i<=n;i++,j++) {
            if(j==source)
                j++;
            path[i]=j;
        }
        int cost = travel(source);
        System.out.print("The Optimal Tour is: ");
        for(int i=1;i<=n;i++)
            System.out.print(finalpath[i]+" -> ");
        System.out.println(source);
        System.out.println("Minimum Cost: "+cost);
    }
}