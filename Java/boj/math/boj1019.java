package CodeTest.Java.boj.math;

import java.io.*;

public class boj1019 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringBuilder sb;

    private static int ans[], point;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {        
        ans = new int[10]; point = 1;
        
        int start = 1, end = Integer.parseInt(br.readLine());

        while(start <= end) {
            while(end%10 != 9 && start <= end) {
                calc(end);
                end--;
            }

            if(end < start) break;

            while(start%10 != 0 && start <= end) {
                calc(start);
                start++;
            }

            start /= 10;
            end /= 10;

            for(int i=0; i<10; i++) ans[i] += (end-start+1)*point;

            point *= 10;
        }

        sb = new StringBuilder();
        for(int i=0; i<10; i++) sb.append(ans[i]).append(' ');

        bw.write(sb.toString());
    }

    private static void calc(int x) {
        while(x > 0) {
            ans[x%10] += point;
            x /= 10;
        }
    }
    
}
