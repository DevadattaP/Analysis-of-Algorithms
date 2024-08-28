import java.util.Scanner;
public class SelectionSort {
    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length -1; i++){
            int minIndex = i;
            for(int j=i+1;j< arr.length;j++){
                if(arr[j] < arr[minIndex])
                    minIndex=j;
            }
            if(minIndex!=i){
                int temp =arr[i];
                arr[i]=arr[minIndex];
                arr[minIndex]=temp;
            }
           /* System.out.println();
            for(int k = 0; k < arr.length; k++)
                System.out.print(arr[k]+" ");*/
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
        selectionSort(array);
        System.out.print("\nAfter Selection Sort: ");
        for (int i = 0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }
}