package practice.week2;

import java.util.ArrayList;
import java.util.List;

public class Day4_Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int N = (int)Math.pow(2, n);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i<N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0;j<n; j++) {
                if ((i & (1<<j)) != 0) list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }
}
