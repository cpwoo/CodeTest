package CodeTest.Java.boj.divideNconquer;

import java.io.*;
import java.util.*;

public class boj6549 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int n, h[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sb = new StringBuilder();
        while(true) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) break;

            h = new int[n];
            for(int i=0; i<n; i++) h[i] = Integer.parseInt(st.nextToken());

            sb.append(maxSquare(0, n-1)).append('\n');
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static long maxSquare(int l, int r) {
        if(l == r) return h[l];
        else {
            int m = (l+r)/2;
            int nl = m, nr = m+1;
            int nh = Math.min(h[nl], h[nr]);
            long tmp = nh*2;

            long cnt = 2;
            while(true) {
                if((h[nl] == 0 || nl == l) && (h[nr] == 0 || nr == r)) break;
                else if(h[nl] == 0 || nl == l) {
                    if(h[nr+1] < nh) nh = h[nr+1];
                    nr++;
                }
                else if(h[nr] == 0 || nr == r) {
                    if(h[nl-1] < nh) nh = h[nl-1];
                    nl--;
                }
                else {
                    if(h[nl-1] > h[nr+1]) {
                        if(h[nl-1] < nh) nh = h[nl-1];
                        nl--;
                    }
                    else {
                        if(h[nr+1] < nh) nh = h[nr+1];
                        nr++;
                    }
                }
                cnt++;
                tmp = Math.max(tmp, nh*cnt);
            }

            return Math.max(tmp, Math.max(maxSquare(l, m), maxSquare(m+1, r)));
        }
    }

}
