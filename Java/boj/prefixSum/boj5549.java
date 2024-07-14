package CodeTest.Java.boj.prefixSum;

import java.io.*;

public class boj5549 {
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
        int m = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);

        int k = Integer.parseInt(br.readLine());
        
        char[][] arr = new char[n][m];
        for(int i=0; i<m; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int[][][] tot = new int[m+1][n+1][3];

        for(int i=1; i<m+1; i++) {
            for(int j=1; j<n+1; j++) {
                if(arr[i-1][j-1]=='J') tot[i][j][0]++;
                if(arr[i-1][j-1]=='O') tot[i][j][1]++;
                if(arr[i-1][j-1]=='I') tot[i][j][2]++;
                
                for(int p=0; p<3; p++) {
                    tot[i][j][p] += tot[i-1][j][p]+tot[i][j-1][p]-tot[i-1][j-1][p];
                }
            }
        }

        for(int i=0; i<k; i++) {
            inp = br.readLine().split(" ");
            int a = Integer.parseInt(inp[0]);
            int b = Integer.parseInt(inp[1]);
            int c = Integer.parseInt(inp[2]);
            int d = Integer.parseInt(inp[3]);
            for(int p=0; p<3; p++) {
                bw.write(tot[c][d][p]-tot[c][b-1][p]-tot[a-1][d][p]+tot[a-1][b-1][p]+" ");
            }
            bw.write("\n");
        }
    }

}
