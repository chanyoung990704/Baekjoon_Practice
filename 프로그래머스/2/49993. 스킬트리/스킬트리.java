class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        for (String tree : skill_trees) {
            String filteredTree = tree.replaceAll("[^" + skill + "]", "");
            if (skill.startsWith(filteredTree)) {
                answer++;
            }
        }
        
        return answer;
    }
}