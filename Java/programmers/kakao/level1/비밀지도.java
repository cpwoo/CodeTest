package CodeTest.Java.programmers.kakao.level1;

public class 비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i=0; i<n; i++) {
            String[] tmp = Integer.toBinaryString(arr1[i]|arr2[i]).split("");
            int t = tmp.length;
            StringBuilder stb = new StringBuilder();
            
            for (int j=0; j<n-t; j++) {
                stb.append(" ");
            }

            for (int j=0; j<t; j++) {
                if (tmp[j].equals("0")) {
                    stb.append(" ");
                } else {
                    stb.append("#");
                }
            }
            
            answer[i] = stb.toString();
        }

        return answer;
    }
}
