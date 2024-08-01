package CodeTest.Java.boj.divideNconquer;

import java.io.*;

public class boj5904 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static final char[] moo = {'m', 'o', 'o'};

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        recur(n, 1, 3);

        bw.flush();
        bw.close();
    }

    private static void recur(int n, int k, int l) throws Exception {
        int L = 2*l + k + 3;
        
        if(n <= 3) {
            bw.write(moo[n-1]+"");
            return;
        }

        if(L < n) recur(n, k+1, L);
        else {
            if(l < n && n <= l+k+3) {
                if(n-l != 1) bw.write('o');
                else bw.write('m');
                return;
            } else {
                recur(n-(l+k+3), 1, 3);
            }
        }
    }

}
