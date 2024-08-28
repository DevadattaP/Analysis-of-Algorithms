import java.util.Scanner;
class Quick
{
    static int[] array;
    static int n;
    public static void swap(int i,int j)
    {
        System.out.println("\nSwap: "+array[i]+" and "+array[j]);

        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void quickSort(int low,int high)  //sort from low to high-1
    {
        if(high - low >1)                           //base case: if high - low <= 1 then do nothing
        {
            int lowerPart=low+1;
            for(int upperPart=low+1;upperPart<high;upperPart++) //partitioning w.r.t. pivot = array[low]
            {
                if(array[upperPart]<=array[low])
                {
                    if(lowerPart!=upperPart)    //not to swap the element with itself
                    {
                        System.out.println("\npivot = "+array[low]);
                        for(int k=low;k<high;k++)
                            System.out.print(array[k]+" ");

                        swap(lowerPart, upperPart);
                    }
                    lowerPart++;
                }
            }
            if(low != lowerPart-1)    //not to swap the element with itself
            {
                System.out.println("\npivot = " + array[low]);
                for (int k = low; k < high; k++)
                    System.out.print(array[k] + " ");

                swap(low, lowerPart - 1);          // move pivot to appropriate place
            }
            quickSort(low,lowerPart-1); //recursive call for lower part
            quickSort(lowerPart,high);      //recursive call for upper part
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of elements in an array: ");
        n = sc.nextInt();

        array = new int[n];
        System.out.print("\nEnter "+ n +" elements in array: ");
        for(int i = 0; i < n;i++)
            array[i] = sc.nextInt();

        quickSort(0,n);

        System.out.print("\nArray after using Quicksort: ");
        for(int i = 0; i < n; i++)
            System.out.print(array[i] + " ");
    }
}