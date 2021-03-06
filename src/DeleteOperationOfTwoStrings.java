/**
 * Created by abiaps on 6/29/2017.
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.
 * <p>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * <p>
 * Use longest common subsequence using dynamic pgmg and subtract it from the length which would give the no. of chars to be deleted from each string
 */
public class DeleteOperationOfTwoStrings {
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - (2 * dp[word1.length()][word2.length()]);
    }

    public static void main(String[] args) {
        System.out.println(minDistance("sea", "ase"));
    }
}
