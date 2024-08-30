package CodeTest.Java.boj.math;

import java.io.*;
import java.util.*;

public class boj9206 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;

    private static double a, b, numOfInterval, interval;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        double v = Double.parseDouble(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        double[] arr = new double[n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            a = Double.parseDouble(st.nextToken());
            b = Double.parseDouble(st.nextToken());
            double h = Double.parseDouble(st.nextToken());

            numOfInterval = Math.ceil(h/0.00005);
            interval = h/numOfInterval;
            
            arr[i] = Math.abs(v-volume());
        }

        double min = Double.MAX_VALUE;
        int idx = -1;
        for(int i=0; i<n; i++) {
            if(min > arr[i]) {
                min = arr[i];
                idx = i;
            }
        }

        bw.write(idx+"");
    }

    private static double volume() {
        double ans = 0.0;
        for(int i=0; i<numOfInterval; i++) {
            double p = interval*i, q = interval*(i+1);
            ans += (interval/6)*(g(p)+4*g((p+q)/2)+g(q));
        }
        return ans;
    }

    private static double g(double x) {
        double fx = f(x);
        return fx*fx*Math.PI;
    }

    private static double f(double x) {
        return a*Math.exp(-(x*x))+b*Math.sqrt(x);
    }

}
