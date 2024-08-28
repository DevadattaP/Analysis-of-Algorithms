import java.util.Scanner;
class QuickSort {
    static int[] array;
    static int n;
    public static int partition(int low,int high) {
        int pivot = array[low];
        System.out.println("pivot = "+pivot);
        int bigIndex = low;
        System.out.println("bigIndex = "+bigIndex);
        int smallIndex = high;
        System.out.println("smallIndex = "+smallIndex);
        while (bigIndex < smallIndex){
            do{
                bigIndex++;
                System.out.println("bigIndex = "+bigIndex);
            }while (array[bigIndex] <= pivot);
            do{
                smallIndex--;
                System.out.println("smallIndex = "+smallIndex);
            }while (array[smallIndex] >= pivot);
            if(bigIndex < smallIndex){
                swap(bigIndex,smallIndex);
            }
        }
        swap(low,smallIndex);
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
        return smallIndex;
    }
    public static void swap(int i,int j) {
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
    public static void quickSort(int low,int high){
        if(low < high){
            int part = partition(low,high);
            System.out.println("part = "+part);
            quickSort(low,part-1);
            quickSort(part,high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter number of elements in an array: ");
        n = sc.nextInt();
        array = new int[n];
        System.out.print("\nEnter "+ n +" elements in array: ");
        for(int i = 0; i < n;i++){
            array[i] = sc.nextInt();
        }
        quickSort(0,n);
        System.out.print("\nArray after using Quicksort: ");
        for(int i = 0; i < n; i++){
            System.out.print(array[i] + " ");
        }
    }
}