import java.util.*;
import java.io.*;

public class ThreeSum {
  public static void main(String args[]) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter the target sum: ");
    int target = Integer.parseInt(br.readLine());
    System.out.print("Enter the number of items in your array: ");
    int length = Integer.parseInt(br.readLine());
    System.out.println("Enter "+length+" numbers:");
    int arr[] = new int[length];
    
    for(int i=0; i<length; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    
    int result[] = sum(arr, target);
    System.out.println(result[0] + " " + result[1] + " " + result[2]);
  }
  
  public static int[] twosum(int arr[], int target, int i) {
    int len = arr.length;
    int start = 0;
    int end = len-1;
    while(start < end) {
      if(end == i) {
        end--;
      }
      else if(start == i) {
        start++;
      }
      if (arr[start] + arr[end] == target) {
        return new int[]{arr[start], arr[end]};
      }
      else if(arr[start] + arr[end] > target) {
        end--;
      }
      else {
        start ++;
      }
    }
    return null;
  }
  
  public static int[] sum(int arr[], int target) {
    Arrays.sort(arr);
    int len = arr.length;
    
    for(int i=0; i<len; i++) {
      if(twosum(arr, target-arr[i], i) != null) {
        int two_sum[] = twosum(arr, target-arr[i], i);
        //System.out.println(two_sum[0] + " " + two_sum[1]);
        if(two_sum[0] + two_sum[1] + arr[i] == target) {
          return new int[]{two_sum[0], two_sum[1], arr[i]};
        }
      }
    }
    return null;
  }
}
