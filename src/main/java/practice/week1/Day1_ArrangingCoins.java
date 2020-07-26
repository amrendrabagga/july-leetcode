package practice.week1;

public class Day1_ArrangingCoins {
    public int arrangeCoins(int n) {
        if (n==1) return 1;
        int res=0;
        int i=1;
        while (n>0) {
            if (n >= i) res++;
            n -= i;
            i++;
        }
        return res;
    }
}
