package CodeTest.Java.programmers.etc.level2;

import java.util.*;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i=0; i<numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        String answer = "";
        for (String num : nums) {
            answer += num;
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
