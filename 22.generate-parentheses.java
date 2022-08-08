import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * algorithms
 * Medium (69.53%)
 * Likes:    12467
 * Dislikes: 483
 * Total Accepted:    1M
 * Total Submissions: 1.5M
 * Testcase Example:  '3'
 *
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * 
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * Input: n = 1
 * Output: ["()"]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 8
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        Queue<ParenthesesString> queue = new LinkedList<>();
        queue.add(new ParenthesesString("",0,0));
        while(!queue.isEmpty()) {
            ParenthesesString ps = queue.poll();
            if(ps.openCount==n && ps.closeCount==n){
                result.add(ps.str);
            } else {
                if (ps.openCount < n) {
                    queue.add( new ParenthesesString(ps.str+"(", ps.openCount+1, ps.closeCount));
                }
                if (ps.openCount > ps.closeCount) {
                    queue.add( new ParenthesesString(ps.str+")", ps.openCount, ps.closeCount+1));
                }
            }
        }
        return result;
    }
    static class ParenthesesString {
        String str;
        int openCount;
        int closeCount;
        public ParenthesesString(String str, int openCount, int closeCount) {
            this.str = str;
            this.openCount = openCount;
            this.closeCount = closeCount;
        }
    }
}
// @lc code=end

