package CodeTest.Java.programmers.kakao.level3;

import java.util.*;

public class 매칭점수 {
    public int solution(String word, String[] pages) {
        int w = word.length();
        int p = pages.length;

        Map<String, Integer> map = new HashMap<String, Integer>();
        List<Page> arr = new ArrayList<Page>();
        word = word.toLowerCase();

        for(int i=0; i<p; i++) {
            pages[i] = pages[i].toLowerCase();
            String st = pages[i];
            int mid = 0, pl = 0, pr = 0;

            while(mid<=pl) {
                pl = st.indexOf("<meta", pl+1);
                pr = st.indexOf(">", pl);
                mid = st.lastIndexOf("https://", pr);
            }

            pr = st.indexOf("\"", mid);
            String url = st.substring(mid,pr);
            
            pl = st.indexOf("<body>", pr);
            int basic = 0;
            for(int start=pl;;) {
                start = st.indexOf(word, start+1);
                if(start == -1) break;
                if(!Character.isLetter(st.charAt(start-1)) &&
                   !Character.isLetter(st.charAt(start+w))) {
                    basic++;
                    start += w;
                }
            }
            
            int link = 0;
            for(int start=pl;;) {
                start = st.indexOf("<a href", start+1);
                if(start == -1) break;
                link++;
            }
            
            map.put(url, i);
            arr.add(new Page(i, basic, link, (double)basic));
        }
        
        for(int i=0; i<pages.length; i++) {
            String st = pages[i];
            for(int pl=0,pr=0;;) {
                pl = st.indexOf("<a href", pr);
                if(pl == -1) break;
                pl = st.indexOf("https://", pl);
                pr = st.indexOf("\"", pl);
                String linkurl = st.substring(pl, pr);
                
                Integer idx = map.get(linkurl);
                if(idx!=null) {
                    Page target = arr.get(idx);
                    Page nowPage = arr.get(i);
                    target.score += (double)nowPage.basic/nowPage.link;
                }
            }
        }
        
        arr.sort(new Comparator<Page>(){
            public int compare(Page p1, Page p2) {
                if(p1.score == p2.score) return p1.idx - p2.idx;
                else {
                    return Double.compare(p2.score, p1.score);
                }
            }
        });
        
        return arr.get(0).idx;
    }

    class Page {
        int idx;
        int basic, link;
        double score;

        Page(int idx, int basic, int link, double score) {
            this.idx = idx;
            this.basic = basic;
            this.link = link;
            this.score = score;
        }
    }
}
