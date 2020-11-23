import java.util.Arrays;

public class HeapSort {
    void sort(int array[]){
        int n = array.length;
        for(int i = n / 2-1; i>=0;i--){
            heap(array,n, i);
        }
        for(int i=n-1;i>0;i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
    }
    void heap(int array[], int len, int in){
        int high = in;
        int left = 2*in+1;
        int right = 2*in+2;
        if(left<len && array[left] > array[high])
            high = left;
        if(right<len && array[right] > array[high])
            high = right;
        if(high != in){
            int temp = array[in];
            array[in] = array[high];
            array[high] = temp;
            heap(array,len, high);
        }
    }

    public static void main(String[] args) {
        int[] data = {5,2,8,3,0,1,2};
        HeapSort hs = new HeapSort();
        hs.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
