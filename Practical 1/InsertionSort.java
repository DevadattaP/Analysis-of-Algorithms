import java.util.Scanner;
public class InsertionSort{
    static void insertionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int key = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
           /* System.out.println();
            for(int k = 0; k < arr.length; k++){
                System.out.print(arr[k]+" ");
            }*/
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];
        System.out.print("\nEnter elements in array: ");
        for (int i = 0;i<array.length;i++)
            array[i] = sc.nextInt();
        System.out.print("\nArray before sorting: ");
        for (int i = 0;i<array.length;i++)
            System.out.print(array[i]+" ");
        insertionSort(array);
        System.out.print("\nAfter Insertion Sort: ");
        for (int i = 0;i<array.length;i++)
            System.out.print(array[i]+" ");

    }
}