package CodeTest.Java.boj.string;

import java.io.*;

public class boj22859 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        solve();

        bw.flush();
        bw.close();
    }

    private static void solve() throws Exception {
        String html = br.readLine();

        // <main> 태그 제거.
        html = html.substring("<main>".length(), html.length() - "</main>".length());

        // <div title="..."> 패턴을 title : ... 형식으로 변환.
        html = html.replaceAll("<div +title=\"([\\w ]*)\">", "title : $1\n");

        // </div> 태그 제거.
        html = html.replaceAll("</div>", "");

        // <p> 태그 제거, </p> 태그를 줄 바꿈으로 대체.
        html = html.replaceAll("<p>", "");
        html = html.replaceAll("</p>", "\n");

        // 남은 모든 HTML 태그 제거.
        html = html.replaceAll("</?[\\w ]*>", "");

        // 줄 바꿈 전후의 공백 정리.
        html = html.replaceAll(" ?\n ?", "\n");

        // 2개 이상의 연속된 공백을 하나의 공백으로 변환.
        html = html.replaceAll(" {2,}", " ");

        bw.write(html);
    }

}
