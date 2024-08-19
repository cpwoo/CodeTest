package CodeTest.Java.boj.sorting;

import java.io.*;
import java.util.*;

public class boj2696 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(tc-- > 0) {
            solve();
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int m = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<>();

        int mid = 0;
        int cnt = 0, cnt2 = 0;
        sb.append((m+1)/2).append('\n');

        for(int i=0; i<(m-1)/10+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                if(cnt++ == m) break;
                int n = Integer.parseInt(st.nextToken());
                if(cnt == 1) mid = n;
                else {
                    if(mid < n) {
                        higher.add(n);
                        if(higher.size() > lower.size()+1) {
                            lower.add(mid);
                            mid = higher.poll();
                        }   
                    }
                    else {
                        lower.add(n);
                        if(higher.size()+1 < lower.size()) {
                            higher.add(mid);
                            mid = lower.poll();
                        }
                    }
                }
                if(cnt%2 == 1) {
                    cnt2++;
                    sb.append(mid).append(' ');
                    if(cnt2%10 == 0 || cnt2 == (m+1)/2) sb.append('\n');
                }
            }
        }
    }

}
