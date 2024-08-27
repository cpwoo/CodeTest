package CodeTest.Java.boj.greedy;

import java.io.*;

public class boj19940 {
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
        int x = Integer.parseInt(br.readLine());
        int[] ans = new int[5];

        ans[0] += x/60;
        x %= 60;

        int d = x/10, m = x%10;
        if(x <= 35) {
            if(m > 5) {
                ans[1] += d+1;
                ans[4] += 10-m;
            }
            else {
                ans[1] += d;
                ans[3] += m;
            }
        }
        else {
            ans[0]++;
            if(m >= 5) {
                ans[2] += 6-(d+1);
                ans[4] += 10-m;
            }
            else {
                ans[2] += 6-d;
                ans[3] += m;
            }
        }

        for(int i=0; i<5; i++) sb.append(ans[i]).append(' ');

        sb.append('\n');
    }
}
