package CodeTest.Java.programmers.etc.level1;

public class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int n = cards1.length, m = cards2.length;
        int i=0, j=0;
        for (String g : goal) {
            if (i<n && cards1[i].equals(g)) i++;
            else if (j<m && cards2[j].equals(g)) j++;
            else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}
