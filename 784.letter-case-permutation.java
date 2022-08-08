import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=784 lang=java
 *
 * [784] Letter Case Permutation
 *
 * https://leetcode.com/problems/letter-case-permutation/description/
 *
 * algorithms
 * Medium (71.88%)
 * Likes:    3216
 * Dislikes: 142
 * Total Accepted:    208.7K
 * Total Submissions: 288.8K
 * Testcase Example:  '"a1b2"'
 *
 * Given a string s, you can transform every letter individually to be
 * lowercase or uppercase to create another string.
 * 
 * Return a list of all possible strings we could create. Return the output in
 * any order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "a1b2"
 * Output: ["a1b2","a1B2","A1b2","A1B2"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "3z4"
 * Output: ["3z4","3Z4"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 12
 * s consists of lowercase English letters, uppercase English letters, and
 * digits.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        if (s == null) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        result.add(s);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isAlphabetic(chars[i])) {
                continue;
            }

            int n = result.size();
            for (int j = 0; j < n; j++) {
                char[] permuteChars = result.get(j).toCharArray();
                if(Character.isUpperCase(permuteChars[i])) {
                    permuteChars[i] = Character.toLowerCase(permuteChars[i]);
                } else {
                    permuteChars[i] = Character.toUpperCase(permuteChars[i]);
                }
                result.add(String.valueOf(permuteChars));
            }
        }

        return result;
    }
}
// @lc code=end

