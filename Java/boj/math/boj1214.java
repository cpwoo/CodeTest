package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1214 {
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
        int d = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        if(d%p == 0 || d%q == 0) {
            bw.write(d+"");
            return;
        }

        if(p > q) {
            int tmp = p;
            p = q;
            q = tmp;
        }

        int ans = (d/q)*q+q;

        int t = ans;
        for(int i=1; i<t/q+1; i++) {
            int tmp = t-q*i;
            if((d-tmp)%p == 0) {
                bw.write(d+"");
                return;
            }
            else tmp += ((d-tmp)/p)*p+p;

            if(ans == tmp) break;
            ans = Math.min(ans, tmp);
        }

        bw.write(ans+"");
    }

}
