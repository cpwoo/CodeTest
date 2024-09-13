package CodeTest.Java.boj.graph;

import java.io.*;
import java.util.*;

public class boj9019 {
    static class CMD {
        int num; StringBuilder path;
        CMD(int num, StringBuilder path) {
            this.num = num;
            this.path = path;
        }
    }

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
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<CMD> q = new ArrayDeque<>();
        q.add(new CMD(a, new StringBuilder()));

        boolean[] visited = new boolean[10000];
        visited[a] = true;

        while(!q.isEmpty()) {
            CMD cmd = q.poll();
            if(cmd.num == b) {
                sb.append(cmd.path).append('\n');
                break;
            }

            int num2 = (2*cmd.num)%10000;
            if(!visited[num2]) {
                q.add(new CMD(num2, new StringBuilder(cmd.path).append('D')));
                visited[num2] = true;
            }

            num2 = (cmd.num-1+10000)%10000;
            if(!visited[num2]) {
                q.add(new CMD(num2, new StringBuilder(cmd.path).append('S')));
                visited[num2] = true;
            }

            num2 = (10*cmd.num+(cmd.num/1000))%10000;
            if(!visited[num2]) {
                q.add(new CMD(num2, new StringBuilder(cmd.path).append('L')));
                visited[num2] = true;
            }

            num2 = (cmd.num/10+(cmd.num%10)*1000)%10000;
            if(!visited[num2]) {
                q.add(new CMD(num2, new StringBuilder(cmd.path).append('R')));
                visited[num2] = true;
            }
        }
    }

}
