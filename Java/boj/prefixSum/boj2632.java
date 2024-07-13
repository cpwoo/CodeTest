package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj2632 {
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
        int size = Integer.parseInt(br.readLine());
        String[] inp = br.readLine().split(" ");
        int m = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);

        int[] A = new int[m];
        int _maxA = 0;
        for(int i=0; i<m; i++) {
            A[i] = Integer.parseInt(br.readLine());
            _maxA += A[i];
        }

        int[] B = new int[n];
        int _maxB = 0;
        for(int i=0; i<n; i++) {
            B[i] = Integer.parseInt(br.readLine());
            _maxB += B[i];
        }

        int[] cntA = new int[Math.max(_maxA,size)+1];
        cntA[0] = 1;
        cntA[_maxA] = 1;

        find(A, cntA, size);

        int[] cntB = new int[Math.max(_maxB,size)+1];
        cntB[0] = 1;
        cntB[_maxB] = 1;

        find(B, cntB, size);

        int ret = 0;
        for(int i=0; i<=size; i++) {
            ret += cntA[i]*cntB[size-i];
        }

        bw.write(ret+"");
    }

    private static void find(int[] pizza, int[] count, int size) {
        for(int i=0; i<pizza.length; i++) {
            int sum = 0;
            for(int j=1; j<pizza.length; j++) {
                int sumJ = pizza[(i+j)%pizza.length];
                if(sum+sumJ > size) break;
                sum += sumJ;
                count[sum]++;
            }
        }
    }

}
