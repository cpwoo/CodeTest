package CodeTest.Java.programmers.etc.level1;

public class 자연수뒤집어배열로만들기 {
    public int[] solution(long n) {
        String[] str = String.valueOf(n).split("");
        int L = str.length;
        int[] answer = new int[L];

        for (int i=0; i<L; i++) {
            answer[i] = Integer.parseInt(str[L-1-i]);
        }
        
        return answer;
    }
}
