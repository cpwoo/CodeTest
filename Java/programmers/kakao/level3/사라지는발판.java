package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

class Game {
    boolean win;
    int turn;

    Game(boolean win, int turn) {
        this.win = win;
        this.turn = turn;
    }
}

public class 사라지는발판 {
    private static int[][] moves = {{0,1},{-1,0},{1,0},{0,-1}};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return simulation(board, aloc, bloc).turn;
    }

    private Game simulation(int[][] board, int[] aloc, int[] bloc) {
        List<Game> results = new ArrayList<>();

        if (board[bloc[0]][bloc[1]] == 0) return new Game(true, 0);
        if (board[aloc[0]][aloc[1]] == 0) return new Game(false, 0);

        for (int[] move : moves) {
            int[] nxtA = new int[]{aloc[0]+move[0], aloc[1]+move[1]};
            if (nxtA[0] < 0 || nxtA[0] >= board.length || nxtA[1] < 0 || nxtA[1] >= board[0].length) continue;
            int nxtV = board[nxtA[0]][nxtA[1]];

            if (nxtV == 1) {
                board[aloc[0]][aloc[1]] = 0;
                Game res = simulation(board, bloc, nxtA);
                board[aloc[0]][aloc[1]] = 1;
                results.add(new Game(!res.win, res.turn+1));
            }
        }

        if (results.size() == 0) return new Game(false, 0);
        else {
            int _min = Integer.MAX_VALUE, _max = 0;
            boolean flag = false;
            for (Game res : results) {
                if (res.win) {
                    flag = true;
                    _min = Math.min(_min, res.turn);
                } else {
                    _max = Math.max(_max, res.turn);
                }
            }
            if (flag) return new Game(true, _min);
            else return new Game(false, _max);
        }
    }   
}
