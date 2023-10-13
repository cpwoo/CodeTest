package CodeTest.Java.programmers.kakao.level1;

public class 키패드누르기 {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] keypad = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,2}};
        int[] left = {3,0}, right = {3,2};

        for (int num : numbers) {
            switch (num) {
                case 1: case 4: case 7:
                    answer += "L";
                    left = keypad[num];
                    break;

                case 3: case 6: case 9:
                    answer += "R";
                    right = keypad[num];
                    break;
                
                default:
                    int distL = Math.abs(left[0]-keypad[num][0]) + Math.abs(left[1]-keypad[num][1]);
                    int distR = Math.abs(right[0]-keypad[num][0]) + Math.abs(right[1]-keypad[num][1]);

                    if (distL < distR) {
                        answer += "L";
                        left = keypad[num];
                    } else if (distL > distR) {
                        answer += "R";
                        right = keypad[num];
                    } else {
                        if (hand.equals("left")) {
                            answer += "L";
                            left = keypad[num];
                        } else {
                            answer += "R";
                            right = keypad[num];
                        }
                    }
            }
        }

        return answer;
    }
}
