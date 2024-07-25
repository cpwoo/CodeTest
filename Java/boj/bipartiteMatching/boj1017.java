package CodeTest.Java.boj.bipartiteMatching;

import java.io.*;
import java.util.*;

public class boj1017 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static int n, arr[], isMatched[];
    private static boolean isPrime[][], v[];

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception { 
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        isMatched = new int[n];
        isPrime = new boolean[n+1][n+1];

        for(int x=0; x<n; x++) {
            for(int y=0; y<n; y++) {
                if(x == y) continue;
                int now = arr[x]+arr[y];
                boolean prime = true;
                for(int z=2; z*z<=now; z++) {
                    if(now%z == 0) {
                        prime = false;
                        break;
                    }
                }
                isPrime[x][y] = prime;
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int x=1; x<n; x++) {
            if(!isPrime[0][x]) continue;
            if(bipertiteMatch(x) == n/2-1) {
                answer.add(arr[x]);
            }
        }

        Collections.sort(answer);
        if(answer.isEmpty()) answer.add(-1);
        for(int a: answer) {
            bw.write(a+" ");
        }
    }

    private static int bipertiteMatch(int x) {
        int ret = 0;
        isMatched = new int[n];
        for(int i=1; i<n; i++) {
            isMatched[i]--;
        }
        isMatched[x] = 0;

        for(int i=1; i<n; i++) {
            if(isMatched[i] != -1) continue;
            v = new boolean[n];
            if(dfs(i)) ret++;
        }
        return ret;
    }

    private static boolean dfs(int i) {
        if(v[i]) return false;
        v[i] = true;
        for(int j=1; j<n; j++) {
            if(isPrime[i][j]) {
                if(isMatched[j] == 0) continue;
                if(isMatched[j] == -1 || dfs(isMatched[j])) {
                    isMatched[j] = i;
                    isMatched[i] = j;
                    return true;
                }
            }
        }
        return false;
    }

}
