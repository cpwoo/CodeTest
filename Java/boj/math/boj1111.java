package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj1111 {
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
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        if(n == 1) {
            bw.write("A");
        }
        else if(n == 2) {
            bw.write((arr[0] == arr[1]) ? arr[0]+"" : "A");
        }
        else {
            int a = (arr[0] == arr[1]) ? 0 : (arr[2]-arr[1])/(arr[1]-arr[0]);
            int b = arr[1]-arr[0]*a;

            for(int i=0; i<n-1; i++) {
                int expect = a*arr[i]+b;
                if(expect != arr[i+1]) {
                    bw.write("B");
                    return;
                }
            }

            bw.write(a*arr[n-1]+b+"");
        }
    }

}
