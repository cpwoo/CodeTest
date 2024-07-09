package CodeTest.Java.boj.binarySearchNternarySearch;

import java.io.*;

public class boj13397 {
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
        int N = Integer.parseInt(inp[0]);
        int M = Integer.parseInt(inp[1]);

        inp = br.readLine().split(" ");
        int[] score = new int[N];

        int start = 0, end = 0;
        for(int i=0; i<N; i++) {
            score[i] = Integer.parseInt(inp[i]);
            end = Math.max(end, score[i]);
        }

        int result = 0;
        while(start <= end) {
            int mid = (start+end)/2;
            int _max = score[0], _min = score[0];
            int cnt = 1;
            for(int i=1; i<N; i++) {
                _max = Math.max(_max, score[i]);
                _min = Math.min(_min, score[i]);
                if(_max-_min > mid) {
                    cnt++;
                    _max = score[i]; _min = score[i];
                }
            }
            if(cnt <= M) {
                end = mid-1;
                result = mid;
            } else {
                start = mid+1;
            }
        }

        bw.write(result+"");
    }

}
