package practice.week3;

public class Day5_AddBinary {
    public static void main(String[] args) {
        System.out.println(2+'0');
        System.out.println(new Day5_AddBinary().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int s = 0;
        String res = "";

        while (i>=0 || j>=0 || s == 1) {
            s += (i>=0 ? a.charAt(i) - '0' : 0);
            s += (j>=0 ? b.charAt(j) - '0' : 0);
            res = (char)(s%2 + '0') + res;

            s /= 2;
            i--;
            j--;
        }
        return res;
    }
}
