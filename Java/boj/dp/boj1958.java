package CodeTest.Java.boj.dp;

import java.io.*;

public class boj1958 {
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
        String X = br.readLine();
        String Y = br.readLine();
        String Z = br.readLine();

        int x = X.length(), y = Y.length(), z = Z.length();

        int[][][] arr = new int[x+1][y+1][z+1];

        for(int i=1; i<x+1; i++) {
            for(int j=1; j<y+1; j++) {
                for(int k=1; k<z+1; k++) {
                    if(X.charAt(i-1) == Y.charAt(j-1) && Y.charAt(j-1) == Z.charAt(k-1)) {
                        arr[i][j][k] = arr[i-1][j-1][k-1]+1;
                    } else {
                        arr[i][j][k] = Math.max(arr[i-1][j][k], Math.max(arr[i][j-1][k], arr[i][j][k-1]));
                    }
                }
            }
        }

        int ret = 0;
        for(int i=0; i<x+1; i++) {
            for(int j=0; j<y+1; j++) {
                for(int k=0; k<z+1; k++) {
                    ret = Math.max(ret, arr[i][j][k]);
                }
            }
        }

        bw.write(ret+"");
    }

}
