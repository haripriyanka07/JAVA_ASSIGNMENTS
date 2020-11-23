import java.util.Arrays;

public class SelectionSort {
    void swap(int array[], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    int findMinIndex(int array[], int start){
        int min = start;
        ++start;
        while(start < array.length){
            if(array[start] < array[min]){
                min = start;
            }
            ++start;
        }
        return min;
    }
    void selectionSort(int array[]){
        for(int i=0;i<array.length;++i){
            int min = findMinIndex(array, i);
            if(i != min){
                swap(array, i, min);
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {5,2,8,3,0,1,2};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(data);
        System.out.println(Arrays.toString(data));
    }
}
