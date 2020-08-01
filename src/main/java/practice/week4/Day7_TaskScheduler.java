package practice.week4;

import java.util.Arrays;

public class Day7_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int []charCount = new int[26];
        for (char c : tasks) {
            charCount[c - 'A']++;
        }
        Arrays.sort(charCount);
        int maxCount = charCount[25] - 1;// -1 as we dont need idle after last char
        int idleCount = n * maxCount;

        for (int i = 24; i>=0; i--) {
            idleCount -= Math.min(charCount[i], maxCount);
            // taking min as in case of AAABBB n=2
            // A _ _ A _ _ A idleCount = 4
            // now while reducing idleCount we check,
            // how many other characters can be filled at a time
            // so it is 2 -> A B _ A B _ A
            // this is so to avoid repeatative chars in seq
        }
        return idleCount > 0 ? idleCount + tasks.length : tasks.length;
    }
}
