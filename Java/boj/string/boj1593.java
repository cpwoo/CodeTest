package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj1593 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String W = br.readLine(), S = br.readLine();

        int[] wa = new int[58], sa = new int[58];

        for(char i : W.toCharArray()) wa[i-'A']++;

        int ret = 0, start = 0, length = 0;
        for(int i=0; i<m; i++) {
            sa[S.charAt(i)-'A']++;
            length++;

            if(length == n) {
                boolean flag = true;
                for(int j=0; j<58; j++) if(wa[j] != sa[j]) {
                    flag = false; break;
                }
                if(flag) ret++;
                sa[S.charAt(start)-'A']--;
                start++;
                length--;
            }
        }

        bw.write(ret+"");
    }

}
