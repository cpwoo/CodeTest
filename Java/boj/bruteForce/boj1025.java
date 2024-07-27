package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1025 {
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
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        String[] numbers = new String[M];
        for(int i=0; i<M; i++) {
            numbers[i] = br.readLine();
        }

        int ret = -1;
        int x, y;

        for(int m=0; m<M; m++) {
            for(int n=0; n<N; n++) {
                for(int weightM=-M; weightM<M; weightM++) {
                    for(int weightN=-N; weightN<N; weightN++) {
                        if(weightM == 0 && weightN == 0) continue;
                        x = m; y = n;
                        StringBuilder value = new StringBuilder();
                        while(0 <= x && x < M && 0 <= y && y < N) {
                            value.append(numbers[x].charAt(y));
                            int num = Integer.parseInt(value.toString());
                            
                            if(checkSqure(num)) {
                                ret = Math.max(ret, num);
                            }

                            x += weightM;
                            y += weightN;
                        }
                    }
                }
            }
        }

        bw.write(ret+"");
    }

    private static boolean checkSqure(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt*sqrt == num;
    }

}
