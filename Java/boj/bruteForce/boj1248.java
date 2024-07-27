package CodeTest.Java.boj.bruteForce;

import java.io.*;

public class boj1248 {
    private static BufferedReader br;
	private static BufferedWriter bw;

    private static int n, s[][], res[];
    private static char arr[];
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
        s = new int[n][n];

        int p = 0;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                char tmp = arr[p++];
                if(tmp == '+') s[i][j] = 1;
                else if(tmp == '-') s[i][j] -= 1;
            }
        }

        res = new int[n];
        
        dfs(0);

        for(int r: res) {
            bw.write(r+" ");
        }
    }

    private static boolean dfs(int idx) {
        if(idx == n) return true;
        
        if(s[idx][idx] == 0) {
            res[idx] = 0;
            return dfs(idx+1);
        }
        
        for(int i=1; i<11; i++) {
            res[idx] = s[idx][idx]*i;
            if(check(idx) && dfs(idx+1)) return true;
        }
        
        return false;
    }

    private static boolean check(int idx) {
        int hap = 0;
        
        for(int i=idx; i>-1; i--) {
            hap += res[i];
            if(hap == 0 && s[i][idx] != 0) return false;
            else if(hap < 0 && s[i][idx] >= 0) return false;
            else if(hap > 0 && s[i][idx] <= 0) return false;
        }
        
        return true;
    }

}
