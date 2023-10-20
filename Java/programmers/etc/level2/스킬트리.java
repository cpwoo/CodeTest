package CodeTest.Java.programmers.etc.level2;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String s : skill_trees) {
            String tmp = "";
            for (String i : s.split("")) {
                if (skill.contains(i)) tmp += i;
            }
            if (skill.substring(0, tmp.length()).equals(tmp)) {
                answer++;
            }
        }
        
        return answer;
    }
}
