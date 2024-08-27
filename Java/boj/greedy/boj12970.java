package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

// String 의 repeat 메소드는 Java 11부터 추가되므로 Java 11로 제출

public class boj12970 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

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
        int k = Integer.parseInt(st.nextToken());

        if((n/2)*(n-n/2) < k) {
            bw.write("-1");
            return;
        }

        for(int i=1; i<n/2+1; i++) {
            int a = i, b = n-i;
            if(a*b >= k) {
                sb = new StringBuilder();
                sb.append("A".repeat(a-1)).append("B".repeat(b+1));
                
                if(a-1 != 0) k -= (a-1)*(b+1)-(a-1);
                else k -= (a-1)*(b+1);

                sb.replace(sb.length()-k-1, sb.length()-k, "A");

                bw.write(sb.toString());
                return;
            }
        }
    }
}
