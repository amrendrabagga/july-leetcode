package practice.week1;

public class Day5_HammingDistance {
    public static int hammingDistance(int x, int y) {

        int m = Math.max(x, y);

        int k = (int) (Math.log(m) / Math.log(2));

        int count = 0;
        for (int i=0; i<=k; i++) {
            int p = (y & (1 << i)) > 0 ? 1 : 0;
            int q = (x & (1 << i)) > 0 ? 1 : 0;

            if ((p ^ q) == 1)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
