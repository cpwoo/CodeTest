package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj16472 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        int ret = 1;
        map.put(str.charAt(0), 1);
        int left = 0, right = 0;

        while(left <= right && right < str.length()) {
            int L = map.size();
            if(L <= n) {
                ret = Math.max(ret, right-left+1);
                right++;
                if(right < str.length()) {
                    map.put(str.charAt(right), map.getOrDefault(str.charAt(right), 0)+1);
                }
            }
            else if(L > n) {
                map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0)-1);
                if(map.get(str.charAt(left)) == 0) map.remove(str.charAt(left));
                left++;
            }
        }

        bw.write(ret+"");
    }

}
