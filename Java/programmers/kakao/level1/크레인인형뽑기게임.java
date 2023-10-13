package CodeTest.Java.programmers.kakao.level1;

import java.util.*;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> tmp = new Stack<>();
        for (int m : moves) {
            for (int i=0; i<board.length; i++) {
                if (board[i][m-1] != 0) {
                    if (!tmp.isEmpty() && board[i][m-1] == tmp.peek()) {
                        answer += 2;
                        tmp.pop();
                        board[i][m-1] = 0;
                        break;
                    }
                    tmp.push(board[i][m-1]);
                    board[i][m-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
