package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj22942 {
    private static BufferedReader br;
	private static BufferedWriter bw;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        int n = Integer.parseInt(br.readLine());
        List<Circle> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new Circle(x-r, i));
            list.add(new Circle(x+r, i));
        }

        Collections.sort(list);

        Stack<Circle> stack = new Stack<>();
        for(int i=0; i<2*n; i++) {
            Circle circle = list.get(i);
            if(stack.isEmpty()) stack.add(circle);
            else {
                if(stack.peek().idx == circle.idx) stack.pop();
                else stack.add(circle);
            }
        }

        bw.write((stack.isEmpty()) ? "YES" : "NO");
    }

}

class Circle implements Comparable<Circle> {
    int point; int idx;
    Circle(int point, int idx) {
        this.point = point;
        this.idx = idx;
    }

    @Override
    public int compareTo(Circle circle) {
        if(this.point != circle.point) {
            return this.point-circle.point;
        } else {
            return this.idx-circle.idx;
        }
    }
}
