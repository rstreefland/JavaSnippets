package uk.co.streefland.rhys.snippets;
import java.util.*;

public class Solution {

    public static void makeRansomNote(int ransomWordCount, int magazineWordCount, String[] ransom, String[] magazine) {

        HashMap<String, Integer> hashMap = new HashMap<>();
        int matchingWords = 0;

        for (int i=0; i < magazineWordCount; i++) {
            hashMap.put(magazine[i], 0);
        }

        for (int i=0; i < ransomWordCount; i++) {
            if(hashMap.containsKey(ransom[i])) {
                hashMap.put(ransom[i],(hashMap.get(ransom[i]).intValue()+ 1));
            }
        }

        for (Map.Entry entry: hashMap.entrySet()) {
            matchingWords += (int) entry.getValue();
        }

        if (matchingWords == ransomWordCount) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        makeRansomNote(n, m, ransom, magazine);
    }
}
