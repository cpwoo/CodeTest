package CodeTest.Java.boj.math;

import java.io.*;

public class boj12850 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    private static final int mod = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();
        
        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        long[][] arr = new long[8][8];
        arr[0][1]=1; arr[0][2]=1; 
    	arr[1][0]=1; arr[1][2]=1; arr[1][3]=1;
    	arr[2][0]=1; arr[2][1]=1; arr[2][3]=1; arr[2][4]=1;
    	arr[3][1]=1; arr[3][2]=1; arr[3][4]=1; arr[3][5]=1;
    	arr[4][2]=1; arr[4][3]=1; arr[4][5]=1; arr[4][7]=1;
    	arr[5][3]=1; arr[5][4]=1; arr[5][6]=1;
    	arr[6][5]=1; arr[6][7]=1;
    	arr[7][4]=1; arr[7][6]=1;

        bw.write(pow(arr, Long.parseLong(br.readLine()))[0][0]+"");
    }

    private static long[][] pow(long[][] a, long b) {
        if(b == 1) return a;
        else if(b%2 == 0) {
            long[][] c = pow(a, b/2);
            return mul(c, c);
        }
        else return mul(a, pow(a, b-1));
    }

    private static long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[8][8];
        for(int i=0; i<8; i++) for(int j=0; j<8; j++) for(int k=0; k<8; k++) {
            c[i][j] = (c[i][j]+(a[i][k]*b[k][j])%mod)%mod;
        }
        return c;
    }

}
