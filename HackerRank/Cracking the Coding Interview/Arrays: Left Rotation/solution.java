import java.io.*;
import java.util.*;
i
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int b[] = new int[n];
        for(int i=0; i<n; i++){
            int pos;
            if(i-k < 0){
                pos=n-(k-i);
            }
            else{
                pos=i-k;
            }
            b[pos]=a[i];
        }
        System.out.print(b[0]);
        for(int b_i=1; b_i < n; b_i++){
            System.out.print(" "+b[b_i]);
        }
    }
}
