import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    
    public static int numberNeeded(String first, String second) {
        int len_first = first.length();
        int len_second = second.length();
        int loop_limit = Math.max(len_first, len_second);
        int difference=0;
        int arr_first[] = new int[26];
        int arr_second[] = new int[26];
        
        for(int i=0; i<loop_limit; i++){
            if(i <= len_first-1) {
                arr_first[first.charAt(i) - 'a']++;
            }
            if(i <= len_second-1) {
                arr_second[second.charAt(i) - 'a']++;
            }
        }
        
        for(int i=0; i<26; i++){
            difference += Math.abs(arr_first[i]-arr_second[i]);
        }
        
        return difference;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}

