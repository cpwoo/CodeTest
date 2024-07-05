package CodeTest.Java.boj.prefixSum;

import java.io.*;
import java.util.*;

public class boj2143 {
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
        int T = Integer.parseInt(br.readLine());
        
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] inp = br.readLine().split(" ");
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(inp[i]);
        }


        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        inp = br.readLine().split(" ");
        for(int i=0; i<M; i++) {
            B[i] = Integer.parseInt(inp[i]);
        }

        Map<Integer, Integer> mapA = new HashMap<>();
        for(int i=0; i<N; i++) {
            int sum = 0;
            for(int j=i; j<N; j++) {
                sum += A[j];
                mapA.put(sum, mapA.getOrDefault(sum, 0)+1);
            }
        }

        long answer = 0;
        for(int i=0; i<M; i++) {
            int sum = 0;
            for(int j=i; j<M; j++) {
                sum += B[j];
                if(mapA.containsKey(T-sum)) {
                    answer += mapA.get(T-sum);
                }
            }
        }

        bw.write(answer+"");
    }

}
