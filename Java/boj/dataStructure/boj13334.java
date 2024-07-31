package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj13334 {
    static class Node {
        int house, office;
        Node(int house, int office) {
            this.house = house;
            this.office = office;
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
        List<Node> info = new ArrayList<>();
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info.add(new Node(a, b));
        }
        int d = Integer.parseInt(br.readLine());
        
        List<Node> roads = new ArrayList<>();
        for(Node node: info) {
            if(Math.abs(node.house-node.office) <= d) {
                if(node.house <= node.office) {
                    roads.add(node);
                } else {
                    roads.add(new Node(node.office, node.house));
                }
            }
        }

        Collections.sort(roads, (o1,o2)->o1.office-o2.office);

        int answer = 0;

        PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->o1.house-o2.house);
        for(Node road: roads) {
            if(q.isEmpty()) q.add(road);
            else {
                while(q.peek().house < road.office-d) {
                    q.poll();
                    if(q.isEmpty()) break;
                }
                q.add(road);
            }
            answer = Math.max(answer, q.size());
        }

        bw.write(answer+"");
    }

}
