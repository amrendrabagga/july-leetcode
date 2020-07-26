package practice.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day6_PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i>=0) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
            i--;
        }
        int[] res = new int[digits.length + 1];
        Arrays.fill(res, 0);
        res[0] = 1;
        return res;
    }
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int i = A.size() - 1;
        while (i>=0) {
            if (A.get(i) != 9) {
                A.set(i, A.get(i) + 1);
                return A;
            }
            A.set(i, 0);
            i--;
        }
        ArrayList<Integer> res = new ArrayList<>(IntStream.range(0, A.size() + 1).boxed().collect(Collectors.toList()));

        res.set(0, 1);
        return res;
    }
}
