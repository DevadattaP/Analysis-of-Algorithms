import java.util.Scanner;
class FractKnapSack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter maximum weight capacity : ");
        double weight_remain = sc.nextDouble();
        double profit = 0;
        System.out.print("Enter number of objects : ");
        int n = sc.nextInt();
        double[][] profit_weight = new double[2][n];
        double[] ratio = new double[n];
        int[] object_taken = new int[n];
        for (int i = 0; i < n; i++){
            System.out.print("\nEnter profit and wait of object "+(i+1)+" : ");
            profit_weight[0][i]=sc.nextInt();
            profit_weight[1][i]=sc.nextInt();
            ratio[i]=profit_weight[0][i]/profit_weight[1][i];
            object_taken[i]=0;
        }
        while (weight_remain!=0){
            double max_ratio=0;
            int maxIndex=-1;
            for(int i=0;i<n;i++)
                if(object_taken[i]==0)
                    if(max_ratio<ratio[i]){
                        max_ratio=ratio[i];
                        maxIndex=i;
                    }
            object_taken[maxIndex]=1;
            if(weight_remain>=profit_weight[1][maxIndex]){
                weight_remain-=profit_weight[1][maxIndex];
                profit+=profit_weight[0][maxIndex];
            }
            else{
                profit+=profit_weight[0][maxIndex]*weight_remain/profit_weight[1][maxIndex];
                weight_remain=0;
            }
        }
        System.out.println("\nMaximum achievable profit = "+profit);
    }
}