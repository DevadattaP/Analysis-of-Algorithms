package test;
public class permutation {
    public static void getPermutations(int[] array,int size,int n){
        if(size==1) {
            System.out.println();
            for (int i : array)
                System.out.print(i + " ");
        }
        for(int i=0;i<size;i++){
            getPermutations(array,size-1,n);

            if(size%2==1){
                int temp =array[0];
                array[0] =array[size-1];
                array[size-1] =temp;
            }
            else{
                int temp =array[i];
                array[i] =array[size-1];
                array[size-1] =temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4};
        getPermutations(numbers,4,4);
    }
}
