package CodeTest.Java.boj.greedy;

import java.io.*;
import java.util.*;

public class boj1374 {
    static class Lecture implements Comparable<Lecture> {
        int s, e;
        Lecture(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Lecture lecture) {
            if(this.s != lecture.s) return this.s-lecture.s;
            return this.e-lecture.e;
        }
    }

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

        PriorityQueue<Lecture> q = new PriorityQueue<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            q.add(new Lecture(s, e));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(0);

        while(!q.isEmpty()) {
            Lecture lecture = q.poll();
            if(lecture.s >= room.peek()) room.poll();
            room.add(lecture.e);
        }

        bw.write(room.size()+"");
    }

}
