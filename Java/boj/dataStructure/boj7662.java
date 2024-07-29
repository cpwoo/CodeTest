package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj7662 {
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
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            PriorityQueue<Long> minq = new PriorityQueue<>();
            PriorityQueue<Long> maxq = new PriorityQueue<>(Collections.reverseOrder());
            int total = 0;
            Map<Long, Long> map = new HashMap<>();

            int t = Integer.parseInt(br.readLine());
            while(t-- > 0) {
                st = new StringTokenizer(br.readLine());
                char operator = st.nextToken().charAt(0);
                long number = Integer.parseInt(st.nextToken());
                if(operator == 'I') {
                    minq.add(number); maxq.add(number);
                    map.put(number, map.getOrDefault(number,0L)+1);
                    total++;
                } else {
                    if(total > 0) {
                        if(number == 1) {
                            while(true) {
                                long del = maxq.poll();
                                if(map.getOrDefault(del, 0L) != 0) {
                                    map.put(del, map.getOrDefault(del, 0L)-1);
                                    break;
                                }
                            }
                        } else {
                            while(true) {
                                long del = minq.poll();
                                if(map.getOrDefault(del, 0L) != 0) {
                                    map.put(del, map.getOrDefault(del, 0L)-1);
                                    break;
                                }
                            }
                        }
                        total--;
                    }
                }
            }

            if(total > 0) {
                long maxv = 0, minv = 0;
                while(true) {
                    maxv = maxq.poll();
                    if(map.getOrDefault(maxv, 0L) != 0) break;
                }
                while(true) {
                    minv = minq.poll();
                    if(map.getOrDefault(minv, 0L) != 0) break;
                }
                bw.write(maxv+" "+minv+"\n");
            } else {
                bw.write("EMPTY"+"\n");
            }
        }
    }

}
