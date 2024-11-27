import java.util.*;
import java.util.regex.*;

class Solution {
    public int solution(String word, String[] pages) {
        word = word.toLowerCase();
        int len = pages.length;
        
        // 페이지 정보를 저장할 Map
        Map<String, Integer> pageMap = new HashMap<>();
        Page[] pageInfo = new Page[len];
        
        // 각 페이지 정보 추출
        for(int i = 0; i < len; i++) {
            String page = pages[i];
            String url = getUrl(page);
            int basicScore = getBasicScore(page, word);
            List<String> links = getLinks(page);
            
            pageInfo[i] = new Page(url, basicScore, links);
            pageMap.put(url, i);
        }
        
        // 링크 점수 계산
        double maxScore = 0;
        int answer = 0;
        
        for(int i = 0; i < len; i++) {
            double linkScore = 0;
            
            // 현재 페이지를 가리키는 외부 링크 검색
            for(int j = 0; j < len; j++) {
                if(i == j) continue;
                
                if(pageInfo[j].links.contains(pageInfo[i].url)) {
                    linkScore += (double)pageInfo[j].basicScore / pageInfo[j].links.size();
                }
            }
            
            double matchScore = pageInfo[i].basicScore + linkScore;
            
            if(maxScore < matchScore) {
                maxScore = matchScore;
                answer = i;
            }
        }
        
        return answer;
    }
    
    // URL 추출
    private String getUrl(String page) {
        Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"(https://\\S*)\"");
        Matcher matcher = pattern.matcher(page);
        matcher.find();
        return matcher.group(1);
    }
    
    // 기본 점수 계산
    private int getBasicScore(String page, String word) {
        page = page.toLowerCase();
        int score = 0;
        int idx = 0;
        
        while(true) {
            idx = page.indexOf(word, idx);
            if(idx == -1) break;
            
            char pre = idx > 0 ? page.charAt(idx-1) : ' ';
            char post = idx + word.length() < page.length() ? 
                page.charAt(idx + word.length()) : ' ';
                
            if(!Character.isLetter(pre) && !Character.isLetter(post)) {
                score++;
            }
            idx += word.length();
        }
        return score;
    }
    
    // 외부 링크 추출
    private List<String> getLinks(String page) {
        List<String> links = new ArrayList<>();
        Pattern pattern = Pattern.compile("<a href=\"(https://\\S*)\"");
        Matcher matcher = pattern.matcher(page);
        
        while(matcher.find()) {
            links.add(matcher.group(1));
        }
        return links;
    }
    
    class Page {
        String url;
        int basicScore;
        List<String> links;
        
        Page(String url, int basicScore, List<String> links) {
            this.url = url;
            this.basicScore = basicScore;
            this.links = links;
        }
    }
}