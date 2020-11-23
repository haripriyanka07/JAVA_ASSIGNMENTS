public class BinarySearch {

    int recursive(int arr[], int low, int high, int val){
        if(high >= low){
            int mid = low + (high - low) / 2;
            if(arr[mid] == val){
                return mid;
            }
            if(arr[mid]>val){
                return recursive(arr, low, mid-1, val);
            }
            return recursive(arr, mid+1, high, val);
        }
        return -1;
    }
    int iterative(int arr[], int val){
        int low =0, high = arr.length-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == val)
                return mid;
            if(arr[mid] < val)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int arr[] = {7,8,9,11,12,24};
        int val = 11;
        System.out.println(bs.recursive(arr, 0, arr.length-1, val));
        System.out.println(bs.iterative(arr, val));
    }
}
