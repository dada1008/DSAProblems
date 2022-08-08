/*
 * @lc app=leetcode id=279 lang=java
 *
 * [279] Perfect Squares
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        
        for(int i=1; i<=n; i++) {
            dp[i] = i;
            for(int j=1; j*j<=i; j++) {
                int sqr = j*j;
                dp[i] = Math.min(dp[i], 1+dp[i-sqr]);
            }
        }
        
        return dp[n];
    }
}
// @lc code=end

