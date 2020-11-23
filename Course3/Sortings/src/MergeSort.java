import java.util.Arrays;

public class MergeSort {
    void merge(int array[], int start, int mid, int end){
        int temp[] = new int[end - start +1];
        int i = start, j= mid+1, k=0;
        while(i <= mid && j<=end){
            if(array[i] <= array[j]){
                temp[k] = array[i];
                k+=1;
                i+=1;
            }else{
                temp[k] = array[j];
                k+=1;
                j+=1;
            }
        }
        while(i<=mid){
            temp[k] = array[i];
            k+=1;
            i+=1;
        }
        while (j<=end){
            temp[k] = array[j];
            k+=1;
            j+=1;
        }
        for(i=start;i<=end;i+=1){
            array[i] = temp[i - start];
        }
    }
    void mergeSort(int a[],int s, int e){
        if(s<e){
            int mid = (s+e)/2;
            mergeSort(a, s, mid);
            mergeSort(a,mid+1,e);
            merge(a, s, mid, e);
        }
    }
    public static void main(String[] args) {
        int[] data = {5,2,8,3,0,1,2};
        MergeSort ms = new MergeSort();
        ms.mergeSort(data, 0, data.length-1);
        System.out.println((Arrays.toString(data)));
    }
}
