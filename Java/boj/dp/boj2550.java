package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2550 {
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
        int n = Integer.parseInt(br.readLine());
        
        int[] L = new int[n];
        st = new StringTokenizer(br.readLine());   
        for(int i=0; i<n; i++) L[i] = Integer.parseInt(st.nextToken());

        int[] R = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) R[i] = Integer.parseInt(st.nextToken());

        int[] d = new int[n+1];
        for(int i=0; i<n; i++) d[R[i]] = i+1;

        int[] LIS = new int[n];
        Stack<Integer> indexes = new Stack<>();

        int num = 0;
        for(int v: L) {
            int now = d[v];
            if(num == 0 || LIS[num-1] < now) {
                indexes.add(num);
                LIS[num++] = now;
            } else {
                int left = 0, right = num;
                while(left < right) {
                    int mid = (left+right)/2;
                    if(LIS[mid] < now) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                if(num == right) LIS[num++] = now;
                else LIS[right] = now;
                indexes.add(right);
            }
        }

        bw.write(num+"\n");

        List<Integer> answer = new ArrayList<>();
        int pos = -1;
        for(Integer index: indexes) pos = Math.max(pos, index);

        while(!indexes.isEmpty()) {
            int v = indexes.pop();
            n--;
            if(pos == v) {
                answer.add(L[n]);
                pos--;
            }
        }

        Collections.sort(answer);
        sb = new StringBuilder();
        for(Integer ans: answer) sb.append(ans).append(' ');

        bw.write(sb.toString());
    }

}
