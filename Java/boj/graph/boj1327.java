package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj1327 {
    static class Reg {
        String str; int cnt;
        Reg(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        String start = "";
        for(int a : arr) start += a;
        
        Arrays.sort(arr);

        String target = "";
        for(int a : arr) target += a;

        Set<String> set = new HashSet<>();

        Deque<Reg> q = new ArrayDeque<>();
        q.add(new Reg(start, 0));

        while(!q.isEmpty()) {
            Reg reg = q.poll();
            String cur = reg.str; int cnt = reg.cnt;

            if(cur.equals(target)) {
                bw.write(cnt+"");
                return;
            }

            if(!set.contains(cur)) {
                set.add(cur);
                for(int i=0; i<n-k+1; i++) {
                    sb = new StringBuilder();
                    sb.append(cur.substring(0, i));
                    sb.append(new StringBuilder(cur.substring(i, i+k)).reverse());
                    sb.append(cur.substring(i+k));
                    q.add(new Reg(sb.toString(), cnt+1));
                }
            }
        }

        bw.write("-1");
    }

}
