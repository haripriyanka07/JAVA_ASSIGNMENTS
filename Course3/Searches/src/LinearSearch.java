import java.util.Scanner;
/* time complexity O(n) */
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of elements");
        int n = sc.nextInt();
        int[] elements = new int[n];
        System.out.println("Enter elements");
        for(int i=0;i<n;i++){
            elements[i] = sc.nextInt();
        }
        System.out.println("Enter element to find");
        int search = sc.nextInt();
        for (int i=0;i<n;i++){
            if(elements[i] == search){
                System.out.println("Found at location "+(i+1));
                break;
            }
            if(i+1 == n){
                System.out.println("Not Found");
            }
        }
    }
}
