package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj20437 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String word = br.readLine();
        int k = Integer.parseInt(br.readLine());

        int[] cnt = new int[26];
        for(char w : word.toCharArray()) cnt[w-'a']++;

        List<Integer> lst[] = new ArrayList[26];
        for(int i=0; i<26; i++) lst[i] = new ArrayList<>();

        boolean flag = false;
        for(int i=0; i<word.length(); i++) {
            int idx = word.charAt(i)-'a';
            if(cnt[idx] >= k) {
                flag = true;
                lst[idx].add(i);
            }
        }

        if(!flag) {
            sb.append("-1\n");
            return;
        }

        int minStr = 10000, maxStr = 0;
        for(int i=0; i<26; i++) for(int j=0; j<lst[i].size()-k+1; j++) {
            int len = lst[i].get(j+k-1)-lst[i].get(j)+1;
            minStr = Math.min(minStr, len);
            maxStr = Math.max(maxStr, len);
        }
        
        sb.append(minStr).append(' ').append(maxStr).append('\n');
    }

}
