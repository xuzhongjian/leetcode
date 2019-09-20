import java.util.*;

/**
 * date    2019-09-17
 * time    15:15
 *
 * @author thisxzj - 中建
 */


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine().trim();
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = func(chars, new boolean[length][length], 0, length - 1);

        int maxI = Integer.MIN_VALUE;
        int maxJ = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (dp[i][j]) {
                    int delta = j - i;
                    maxI = delta > max ? i : maxI;
                    maxJ = delta > max ? j : maxJ;
                    max = delta;
                }
            }
        }
        System.out.println(s.substring(maxI, maxJ));
    }

    public static boolean[][] func(char[] chars, boolean[][] dp, int ii, int jj) {
        int length = dp.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //i - 1
                //j + 1
                if (chars[i - 1] == chars[j + 1]) {

                }
            }
        }
        return dp;
    }
}
