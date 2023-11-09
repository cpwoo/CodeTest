package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 표병합 {
    public List<String> solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        
        int[][][] merged = new int[51][51][2];
        for (int i=0; i<=50; i++) {
            for (int j=0; j<=50; j++) {
                merged[i][j][0] = i;
                merged[i][j][1] = j;
            }
        }

        String[][] content = new String[51][51];
        for (int i=0; i<=50; i++) {
            Arrays.fill(content[i], "EMPTY");
        }
        
        System.out.println(content[50][50]);

        for (String command : commands) {
            String[] cmd = command.split(" ");
            
            if (cmd[0].equals("UPDATE")) {
                if (cmd.length == 4) {
                    int r = Integer.valueOf(cmd[1]);
                    int c = Integer.valueOf(cmd[2]);
                    String value = cmd[3];
                    int x = merged[r][c][0], y = merged[r][c][1];
                    content[x][y] = value;
                }
                else {
                    String val1 = cmd[1], val2 = cmd[2];
                    for (int i=1; i<=50; i++) {
                        for (int j=1; j<=50; j++) {
                            if (content[i][j].equals(val1)) {
                                content[i][j] = val2;
                            }
                        }
                    }
                }
            }
            else if (cmd[0].equals("MERGE")) {
                int r1 = Integer.valueOf(cmd[1]);
                int c1 = Integer.valueOf(cmd[2]);
                int r2 = Integer.valueOf(cmd[3]);
                int c2 = Integer.valueOf(cmd[4]);

                int x1 = merged[r1][c1][0], y1 = merged[r1][c1][1];
                int x2 = merged[r2][c2][0], y2 = merged[r2][c2][1];
                
                if (content[x1][y1].equals("EMPTY")) {
                    content[x1][y1] = content[x2][y2];
                }

                for (int i=1; i<=50; i++) {
                    for (int j=1; j<=50; j++) {
                        if (merged[i][j][0] == x2 && merged[i][j][1] == y2) {
                            merged[i][j][0] = x1; merged[i][j][1] = y1;
                        } 
                    }
                }
            }
            else if (cmd[0].equals("UNMERGE")) {
                int r = Integer.valueOf(cmd[1]);
                int c = Integer.valueOf(cmd[2]);
                int x = merged[r][c][0], y = merged[r][c][1];
                String tmp = content[x][y];

                for (int i=1; i<=50; i++) {
                    for (int j=1; j<=50; j++) {
                        if (merged[i][j][0] == x && merged[i][j][1] == y) {
                            merged[i][j][0] = i; merged[i][j][1] = j;
                            content[i][j] = "EMPTY";
                        }
                    }
                }
                content[r][c] = tmp;
            }
            else if (cmd[0].equals("PRINT")) {
                int r = Integer.valueOf(cmd[1]);
                int c = Integer.valueOf(cmd[2]);
                int x = merged[r][c][0], y = merged[r][c][1];
                answer.add(content[x][y]);
            }
        }

        return answer;
    }
}
