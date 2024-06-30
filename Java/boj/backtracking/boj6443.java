package CodeTest.Java.boj.backtracking;

import java.io.*;
import java.util.*;

public class boj6443 {
    private static BufferedWriter bw;
    private static char[] arr;
    private static int L;
    private static boolean[] visited;
    private static char[] mx, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            arr = br.readLine().toCharArray();
            Arrays.sort(arr);

            L = arr.length;
            visited = new boolean[L];
            mx = new char[L];
            answer = new char[L];

            dfs(0);
        }

        bw.flush();
        bw.close();
    }

    private static void dfs(int cnt) throws Exception {
        if(cnt == L) {
            bw.write(answer);
            bw.write('\n');
            return;
        }

        mx[cnt] = 0;
        for(int i=0; i<L; i++) {
            if(mx[cnt] >= arr[i]) continue;
            if(!visited[i]) {
                visited[i] = true;
                mx[cnt] = answer[cnt] = arr[i];
                dfs(cnt+1);
                visited[i] = false;
            }
        }
    }

}
