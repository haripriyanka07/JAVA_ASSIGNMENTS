import java.util.Arrays;

public class InsertionSort {
    void sort(int array[]){
        int n = array.length;
        for(int i =1; i<n;i++){
            int key = array[i];
            int j = i-1;
            while (j>=0 && array[j]>key){
                array[j+1] = array[j];
                j=j-1;
            }
            array[j+1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {5,2,8,3,0,1,2};
        InsertionSort is = new InsertionSort();
        is.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
