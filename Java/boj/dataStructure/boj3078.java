package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj3078 {
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
        int k = Integer.parseInt(st.nextToken());

        int[] student = new int[n];
        int[] num = new int[21];
        long cnt = 0;

        for(int i=0; i<n; i++) {
            student[i] = br.readLine().length();
            if(i > k) {
                num[student[i-k-1]]--;
            }
            cnt += num[student[i]];
            num[student[i]]++;
        }

        bw.write(cnt+"");
    }

}
