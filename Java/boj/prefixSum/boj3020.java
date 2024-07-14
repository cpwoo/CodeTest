package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj3020 {
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
        String[] inp = br.readLine().split(" ");
        int n = Integer.parseInt(inp[0]);
        int h = Integer.parseInt(inp[1]);

        int[] down = new int[h+1];
        int[] up = new int[h+1];

        int _min = 1000001;
        int cnt = 0;

        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(i%2 == 0) down[x]++;
            else up[x]++;
        }

        for(int i=h-1; i>0; i--) {
            down[i] += down[i+1];
            up[i] += up[i+1];
        }

        for(int i=1; i<h+1; i++) {
            if(_min > down[i]+up[h-i+1]) {
                _min = down[i]+up[h-i+1];
                cnt = 1;
            } else if(_min == down[i]+up[h-i+1]) {
                cnt++;
            }
        }

        bw.write(_min+" "+cnt+"");
    }

}
