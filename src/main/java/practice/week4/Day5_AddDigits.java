package practice.week4;

public class Day5_AddDigits {
    // this results in O(n)
    public int addDigits(int num) {
        if (num < 10) return num;
        int res = 0;
        while (num/10 != 0) {
            res += num%10;
            num /= 10;
        }
        return addDigits(num+res);
    }

    // another efficient solution
    public int addDigitsEfficient(int num) {
        if (num==0) return 0;
        return (num % 9 == 0) ? 9 : num % 9;
    }
}
