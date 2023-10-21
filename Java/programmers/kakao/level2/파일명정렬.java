package CodeTest.Java.programmers.kakao.level2;

import java.util.*;

public class 파일명정렬 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int ret = head1.toLowerCase().compareTo(head2.toLowerCase());

                if (ret == 0) ret = convertNum(o1, head1) - convertNum(o2, head2);

                return ret;
            }
        });

        return files;
    }

    private static int convertNum(String str, String head) {
        str = str.substring(head.length());
        String ret = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && ret.length() < 5) ret += c;
            else break;
        }
        return Integer.valueOf(ret);
    }
}
