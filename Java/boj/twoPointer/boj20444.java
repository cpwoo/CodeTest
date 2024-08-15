package CodeTest.Java.boj.twoPointer;

import java.io.*;
import java.util.*;

public class boj20444 {
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
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long left = 0, right = n/2;

        boolean chk = false;

        while(left <= right) {
            long rowCut = (left+right)/2;
            long colCut = n-rowCut;
            long pieces = (rowCut+1)*(colCut+1);

            if(k == pieces) {
                bw.write("YES");
                chk = true;
                break;
            }
            if(k > pieces) left = rowCut+1;
            else right = rowCut-1;
        }

        if(!chk) bw.write("NO");
    }

}
