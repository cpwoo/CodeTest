package CodeTest.Java.boj.bruteForce;

import java.io.*;
import java.util.*;

public class boj1239 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    private static boolean v[];
    private static int n, ans, s[], line[];
    private static Set<String> set;
    
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        n = Integer.parseInt(br.readLine());
        s = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            s[i] = Integer.parseInt(st.nextToken());
            if(s[i] > 50) {
                bw.write(0+"");
                return;
            }
        }
        
        ans = 0;
        v = new boolean[n];
        line = new int[n];
        set = new HashSet<>();

        permutations(0);

        bw.write(ans+"");
    }

    private static void permutations(int idx) {
        if(idx == n) {
            if(!set.contains(Arrays.toString(line))) {
                calc();
            }
            set.add(Arrays.toString(line));
            return;
        }

        for(int i=0; i<n; i++) {
            if(v[i]) continue;
            line[idx] = s[i];
            v[i] = true;
            permutations(idx+1);
            v[i] = false;
        }
    }

    private static void calc() {
        int cnt = 0, left = 0, right = 0, sum = 0;
        while(right < n) {
            if(sum < 50) {
                sum += line[right++];
            } else if(sum == 50) {
                cnt++;
                sum += line[right++];
            } else {
                sum -= line[left++];
            }
        }

        ans = Math.max(ans, cnt);
    }
    
}
