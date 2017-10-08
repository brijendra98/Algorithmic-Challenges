import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        if(n>m){
            System.out.println("No");
            return;
        }
        Map<String, Integer> magazine = new HashMap<>();
        Map<String, Integer> note = new HashMap<>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            String mg = in.next();
            if(magazine.get(mg) == null){
                magazine.put(mg,1);
            }
            else{
                magazine.put(mg, magazine.get(mg)+1);
            }
        }
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            String nt = in.next();
            if(note.get(nt) == null){
                note.put(nt,1);
            }
            else{
                note.put(nt, note.get(nt)+1);
            }
        }
        for (String key : note.keySet()) {
            if(magazine.get(key) == null || magazine.get(key) < note.get(key)){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}

