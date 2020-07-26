package practice.week4;

import java.util.Arrays;

public class Day2_SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int res[] = new int[2];
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        // find righmost set bit
        int setBit = xor ^ (xor & (xor-1));
        for (int n : nums) {
            if ((n & setBit) == 0)
                res[0] ^= n;
        }
        res[1] = res[0] ^ xor;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Day2_SingleNumber3().singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
