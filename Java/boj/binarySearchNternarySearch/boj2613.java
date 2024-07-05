package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj2613 {
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
        int m = Integer.parseInt(inp[1]);

        int[] beads = new int[n];

        inp = br.readLine().split(" ");
        int start = 0, end = 0;
        for(int i=0; i<n; i++) {
            beads[i] = Integer.parseInt(inp[i]);
            start = Math.max(start, beads[i]);
            end += beads[i];
        }

        int mid = 0;
        while(start <= end) {
            mid = (start+end)/2;

            int sum = 0, cnt = 1;
            for(int i=0; i<n; i++) {
                sum += beads[i];
                if(mid < sum) {
                    cnt++;
                    sum = beads[i];
                }
            }

            if(cnt > m) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        bw.write(start+"\n");

        int sum = 0, cnt = 0;
        for(int i=0; i<n; i++) {
            sum += beads[i];
            if(start < sum) {
                m--;
                sum = beads[i];
                bw.write(cnt+" ");
                cnt = 1;
            } else {
                cnt++;
            }
            if(m == n-i) break;
        }

        while(m-- > 0) {
            bw.write(cnt+" ");
            cnt = 1;
        }
    }

}
