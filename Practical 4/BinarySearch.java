import java.util.Scanner;
class BinarySearch{
    static int[] array;
    public static int binarySearch(int low, int high,int key){
        if(low==high)
        {
            if(array[low]==key)
                return low;
            else
                return -1;
        }
        else
        {
            int mid = (low + high) / 2;
            if(array[mid]==key)
                return mid;
            else if(array[mid]>key)
                return binarySearch(low,mid-1,key);
            else
                return binarySearch(mid+1,high,key);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter the number of elements in array: ");
        int n = sc.nextInt();
        array = new int[n];
        System.out.print("\nEnter "+n+" elements in ascending order: ");
        for(int i=0;i<n;i++)
            array[i]=sc.nextInt();
        System.out.print("\nEnter the element you want to search: ");
        int key = sc.nextInt();
        int index = binarySearch(0,n-1,key);
        if(index==-1)
            System.out.println("\nSorry!!! Either search element is not present in array or the array is not sorted :(");
        else
            System.out.println("\n"+key+" is present at index "+index);
    }
}