package CodeTest.Java.boj.dataStructure;

import java.io.*;
import java.util.*;

public class boj17299 {
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
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int[] answer = new int[n];
        Arrays.fill(answer, -1);

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && map.get(arr[stack.peek()]) < map.get(arr[i])) {
                answer[stack.pop()] = arr[i];
            }
            stack.add(i);
        }

        for(int a: answer) {
            bw.write(a+" ");
        }
    }

}
