package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 단체사진찍기 {
    static HashMap<Character,Integer> map;
    static boolean[] visited;
    static int[] ch;
    static int answer;
    
    public int solution(int n, String[] data) {
        map = new HashMap<>();
        map.put('A',0); map.put('C',1);
        map.put('F',2); map.put('J',3);
        map.put('M',4); map.put('N',5);
        map.put('R',6); map.put('T',7);

        visited = new boolean[8];
        ch = new int[8];
        answer = 0;
        dfs(0, data);
        
        return answer;
    }
    
    private static void dfs(int idx, String[] data){
        if(idx == 8) {
            if(check(data)) answer++;
        } else {
            for (int i=0; i<8; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    ch[idx] = i;
                    dfs(idx+1, data);
                    visited[i] = false;
                }
            }
        }
    }
    
    private static boolean check(String[] data){
        for(String d : data){
            int a = ch[map.get(d.charAt(0))];
            int b = ch[map.get(d.charAt(2))];
            char op = d.charAt(3);
            int res = d.charAt(4)-'0' + 1;
            
            if(op == '=') {
                if (Math.abs(a-b) != res) return false;
            } else if (op == '>') {
                if (Math.abs(a-b) <= res) return false;
            } else {
                if (Math.abs(a-b) >= res) return false;
            }
        }
        return true;
    }
}
