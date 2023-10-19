package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                board[r][c] = r*columns+(c+1);
            }
        }
        
        for (int i=0; i<queries.length; i++) {
            int[] query = queries[i];
            int r1 = query[0]-1, c1 = query[1]-1, r2 = query[2]-1, c2 = query[3]-1;
            List<Integer> stk = new ArrayList<>();
            
            for (int a=c1; a<=c2; a++) {
                stk.add(board[r1][a]);
                if (stk.size() == 1) continue;
                else board[r1][a] = stk.get(stk.size()-2);
            }
            
            for (int b=r1+1; b<=r2; b++) {
                stk.add(board[b][c2]);
                board[b][c2] = stk.get(stk.size()-2);
            }
            
            for (int c=c2-1; c>=c1; c--) {
                stk.add(board[r2][c]);
                board[r2][c] = stk.get(stk.size()-2);
            }
            
            for (int d=r2-1; d>=r1; d--) {
                stk.add(board[d][c1]);
                board[d][c1] = stk.get(stk.size()-2);
            }
            
            int ret = Integer.MAX_VALUE;
            for (int s : stk) {
                ret = Math.min(ret, s);
            }
            answer[i] = ret;
        }
        
        return answer;
    }
}
