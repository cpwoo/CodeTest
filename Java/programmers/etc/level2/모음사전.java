package CodeTest.Java.programmers.etc.level2;

public class 모음사전 {
    public int solution(String word) {
        /*
         * "I"가 1563번째
         * AAAAA가 1562/2=781번째 
         * UUUUU가 781*5=3905번째
         */
        int answer = 0, perm = 3905;
        for (String w : word.split("")) {
            perm /= 5;
            answer += "AEIOU".indexOf(w)*perm+1;
        }
        return answer;
    }
}
