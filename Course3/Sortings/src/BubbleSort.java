import java.util.Arrays;

public class BubbleSort {
    void swap(int array[], int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    void sort(int a[]){
        int i,j;
        int n = a.length;
        boolean swapped;
        for(i=0;i<n;i++){
            swapped = false;
            for(j=0;j<n-i-1; j++){
                if(a[j] > a[j+1]){
                    swap(a, j, j+1);
                    swapped = true;
                }
            }
            if(swapped == false){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] data = {5,2,8,3,0,1,2};
        BubbleSort bs = new BubbleSort();
        bs.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
