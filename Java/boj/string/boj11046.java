package CodeTest.Java.boj.string;

import java.io.*;
import java.util.*;

public class boj11046 {
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
        int n = Integer.parseInt(br.readLine());
        int L = 2*n+1;
        
        int[] nums = new int[L];
        Arrays.fill(nums, -1);

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<2*n+1; i+=2) nums[i] = Integer.parseInt(st.nextToken());

        int[] a = new int[L];
        for(int i=0, c=0, r=0; i<2*n+1; i++) {
            a[i] = (i > r) ? 0 : Math.min(a[2*c-i], r-i);

            while(i-(a[i]+1) >= 0 && i+(a[i]+1) < L && nums[i-a[i]-1] == nums[i+a[i]+1]) a[i]++;

            if(r < i+a[i]) {
                r = i+a[i];
                c = i;
            }
        }

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int center = s+e-1, rad = e-s;

            sb.append((rad <= a[center]) ? "1\n" : "0\n");
        }

        bw.write(sb.toString());
    }

}
