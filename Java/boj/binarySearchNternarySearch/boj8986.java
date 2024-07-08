package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj8986 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int N;
    private static long arr[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        String[] inp = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            arr[i] = Long.parseLong(inp[i]);
        }

        long start = 0, end = arr[N-1];

        long left, right;
        while(end-start >= 3) {
            left = (start*2+end)/3; right = (start+end*2)/3;
            if(sum(left) < sum(right)) {
                end = right;
            } else {
                start = left;
            }
        }

        long _min = Long.MAX_VALUE;
        for(long i=start; i<end+1; i++) {
            _min = Math.min(_min, sum(i));
        }

        bw.write(_min+"");
    }

    private static long sum(long x) {
        long tmp = 0;
        for(int i=0; i<N; i++) {
            tmp += Math.abs(arr[i]-x*i);
        }
        return tmp;
    }

}
