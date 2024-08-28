import java.util.Scanner;
public class FindMaxMin{
    static int[] array;
    static int max;
    static int min;
    static void findMaxMin(int minIndex, int maxIndex) {
        if(minIndex==maxIndex){
            min=array[minIndex];
            max=array[maxIndex];
        }
        else if(minIndex==maxIndex-1){
            if(array[minIndex]>array[maxIndex]){
                max=array[minIndex];
                min=array[maxIndex];
            }
            else {
                min=array[minIndex];
                max=array[maxIndex];
            }
        }
        else {
            int midIndex = (minIndex + maxIndex) / 2;
        //    for(int i=minIndex; i<=midIndex; i++)
        //        System.out.print(array[i]+" ");
        //   System.out.println();
            findMaxMin(minIndex, midIndex);
            int min1 = min;
            int max1 = max;
        //    System.out.println("\t"+min1+" "+max1);
        //    for(int i=midIndex+1; i<=maxIndex; i++)
        //        System.out.print(array[i]+" ");
        //    System.out.println();
            findMaxMin(midIndex + 1, maxIndex);
            if (max1 > max)
                max = max1;
            if (min1 < min)
                min = min1;
        //    System.out.println("\t\t"+min+" "+max);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert length of array: ");
        int length = sc.nextInt();
        System.out.print("Enter "+length+" elements: ");
        array = new int[length];
        for(int i=0; i<length; i++)
            array[i]=sc.nextInt();
        findMaxMin(0,length-1);
        System.out.println("Minimum element in array is "+min);
        System.out.println("Maximum element in array is "+max);
    }
}