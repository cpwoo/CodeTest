package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj13325 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int h, edges[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        h = Integer.parseInt(br.readLine());

        int n = (1<<(h+1))-1;
        edges = new int[n-1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n-1; i++) edges[i] = Integer.parseInt(st.nextToken());

        calc(0);

        int sum = 0;
        for(int i=0; i<n-1; i++) sum += edges[i];

        bw.write(sum+"");
    }

    private static int calc(int i) {
        if(i >= (1<<h)-1) return 0;
        int left = edges[2*i]+calc(2*i+1);
        int right = edges[2*i+1]+calc(2*i+2);
        
        if(left > right) edges[2*i+1] += left-right;
        else edges[2*i] += right-left;

        return Math.max(left, right);
    }

}
