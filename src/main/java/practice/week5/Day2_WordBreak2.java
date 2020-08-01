package practice.week5;

import java.util.*;

public class Day2_WordBreak2 {

    Map<String, List<String>> map = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {

        if (map.containsKey(s))
            return map.get(s);
        List<String> res = new ArrayList<>();
        if (wordDict.contains(s))
            res.add(s);

        for (int i = 1; i<s.length(); i++) {
            String left = s.substring(0, i);
            if (wordDict.contains(left)) {
                List<String> subList = wordBreak(s.substring(i), wordDict);
                for (String tmp : subList) {
                    res.add(left + " " + tmp);
                }
            }
        }
        map.put(s, res);
        return res;
    }

    private boolean checkWordCanBeBroken(String s, List<String> wordDict) {
        // Word Break 1 problem
        if (s.length() == 0) return true;
        Set<String> set = new HashSet<>(wordDict);
        List<Integer> matchedIndex = new ArrayList<>();
        matchedIndex.add(-1);
        boolean dp[] = new boolean[s.length()+1];

        for (int i=0; i<=s.length(); i++) {
            int matchedIndexSize = matchedIndex.size();
            int flag = 0;
            for (int j = matchedIndexSize - 1; j>=0; j--) {
                String sb = s.substring(matchedIndex.get(j) + 1, i);
                if (wordDict.contains(sb)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                matchedIndex.add(i - 1);
                dp[i] = true;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList( "mobile", "samsung", "sam",
                "sung", "man", "mango",
                "icecream", "and", "go",
                "i", "like", "ice", "cream" );
        Day2_WordBreak2 obj = new Day2_WordBreak2();
        System.out.println(obj.checkWordCanBeBroken("ilikesamsung", wordDict));
        System.out.println(obj.checkWordCanBeBroken("iiiiiiii", wordDict));
        System.out.println(obj.checkWordCanBeBroken("iiiiiiii", wordDict));
        System.out.println(obj.checkWordCanBeBroken("ilikelikeimangoiii", wordDict));
        System.out.println(obj.checkWordCanBeBroken("samsungandmangok", wordDict));


    }
}
