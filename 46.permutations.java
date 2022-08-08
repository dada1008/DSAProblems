import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode id=46 lang=java
 *
 * [46] Permutations
 *
 * https://leetcode.com/problems/permutations/description/
 *
 * algorithms
 * Medium (71.56%)
 * Likes:    9961
 * Dislikes: 181
 * Total Accepted:    1.1M
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,2,3]'
 *
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 * 
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 * Input: nums = [1]
 * Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * All the integers of nums are unique.
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length==0) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int n = permutations.size();
            for (int j = 0; j < n; j++) {

                List<Integer> oldPermutations = permutations.poll();
                for (int k = 0; k <= oldPermutations.size(); k++) {
                    List<Integer> permutation = new ArrayList<>(oldPermutations);
                    permutation.add(k, currentNumber);
                    if (permutation.size() == nums.length) {
                        result.add(permutation);
                    } else {
                        permutations.add(permutation);
                    }
                }
            }
        }
        return result;
    }
}
// @lc code=end

