package CodeTest.Java.boj.dp;

import java.io.*;
import java.util.*;

public class boj2568 {
    static class Line implements Comparable<Line> {
        int a, b;
        Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line line) {
            if(this.a != line.a) {
                return this.a-line.a;
            }
            return this.b-line.b;
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
        int n = Integer.parseInt(br.readLine());
        List<Line> q = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            q.add(new Line(x, y));
        }

        Collections.sort(q);

        int[] c = new int[n];
        List<Integer> d = new ArrayList<>();
        int num = 0;
        for(Line line: q) {
            int left = 0, right = num;
            while(left < right) {
                int mid = (left+right)/2;
                if(c[mid] < line.b) left = mid+1;
                else right = mid;
            }
            if(num != right) c[right] = line.b;
            else c[num++] = line.b;
            d.add(right+1);
        }

        bw.write(n-num+"\n");

        Stack<Integer> e = new Stack<>();
        for(int i=d.size()-1; i>=0; i--) {
            if(d.get(i) == num) num--;
            else e.add(q.get(i).a);
        }

        sb = new StringBuilder();
        while(!e.isEmpty()) sb.append(e.pop()).append('\n');
        
        bw.write(sb.toString());
    }

}
