package CodeTest.Java.programmers.kakao.level4;

import java.util.*;

public class 블록게임 {
    public int solution(int[][] board) {
        int n = board.length; 
        int answer = 0;
        int cnt = 0;
        List<int[]> black = new ArrayList<>();

        while (cnt <= 2) {
            cnt++;
            for (int col=0; col<n; col++) {
                int idx = 0;
                while (true) {
                    if (board[0][col] != 0) break;
                    if (idx >= n-1) {
                        board[idx][col] = -1;
                        black.add(new int[]{idx, col});
                        break;
                    }
                    if (board[idx+1][col] != 0) {
                        board[idx][col] = -1;
                        black.add(new int[]{idx, col});
                        break;
                    }
                    idx++;
                }
            }

            for (int row=0; row<n-1; row++) {
                for (int col=0; col<n-2; col++) {
                    int minus = 0, zero = 0;
                    Set<Integer> block = new HashSet<>();
                    if (board[row][col] != 0) {
                        for (int p=row; p<=row+1; p++) {
                            for (int q=col; q<=col+2; q++) {
                                block.add(board[p][q]);
                                if (board[p][q] == -1) minus++;
                                if (board[p][q] == 0) zero++;
                            }
                        }
                    }
                    if (minus == 2 && zero == 0 && block.size() == 2) {
                        answer++;
                        for (int p=row; p<=row+1; p++) {
                            for (int q=col; q<=col+2; q++) {
                                board[p][q] = 0;
                            }
                        }
                        for (int[] idx : black) {
                            board[idx[0]][idx[1]] = 0;
                        }
                        black.clear();
                        cnt = 0;
                    }
                }
            }

            for (int row=0; row<n-2; row++) {
                for (int col=0; col<n-1; col++) {
                    int minus = 0, zero = 0;
                    Set<Integer> block = new HashSet<>();
                    if (board[row][col] != 0) {
                        for (int p=row; p<=row+2; p++) {
                            for (int q=col; q<=col+1; q++) {
                                block.add(board[p][q]);
                                if (board[p][q] == -1) minus++;
                                if (board[p][q] == 0) zero++;
                            }
                        }
                    }
                    if (minus == 2 && zero == 0 && block.size() == 2) {
                        answer++;
                        for (int p=row; p<=row+2; p++) {
                            for (int q=col; q<=col+1; q++) {
                                board[p][q] = 0;
                            }
                        }
                        for (int[] idx : black) {
                            board[idx[0]][idx[1]] = 0;
                        }
                        black.clear();
                        cnt = 0;
                    }
                }
            }
        }

        return answer;
    }
}
