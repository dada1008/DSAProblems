package com.opensource.dada.ds.tree;

import com.opensource.dada.microsoft.PermutationPalindrome;
import org.junit.jupiter.api.Test;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

/**
 * Problem:https://www.interviewcake.com/question/java/balanced-binary-tree?utm_source=weekly_email&utm_source=drip&utm_campaign=weekly_email&utm_campaign=Interview%20Cake%20Weekly%20Problem%20%23261:%20Balanced%20Binary%20Tree&utm_medium=email&utm_medium=email
 * Write a method to see if a binary tree ↴ is "superbalanced" (a new tree property we just made up).
 *
 * Your first thought might be to write a recursive method, thinking,
 * "the tree is balanced if the left subtree is balanced and the right subtree is balanced."
 * This kind of approach works well for some other tree problems.
 *
 * But this isn't quite true. Counterexample: suppose that from the root of our tree:
 *
 * The left subtree only has leaves at depths 10 and 11.
 * The right subtree only has leaves at depths 11 and 12.
 * Both subtrees are balanced, but from the root we will have leaves at 3 different depths.
 *
 * We could instead have our recursive method get the array of distinct leaf depths for each subtree.
 * That could work fine. But let's come up with an iterative solution instead.
 * It's usually better to use an iterative solution instead of a recursive one because it avoids stack overflow.
 *
 * We can do this in O(n)O(n) time and O(n)O(n) space.
 *
 * What about a tree with only one leaf node? Does your method handle that case properly?
 */
public class SuperBalancedBinaryTree {

    private static class NodeDepthPair {

        TreeNode node;
        int depth;

        NodeDepthPair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static boolean isBalanced(TreeNode treeRoot) {

        // a tree with no nodes is superbalanced, since there are no leaves!
        if (treeRoot == null) {
            return true;
        }

        // we short-circuit as soon as we find more than 2
        List<Integer> depths = new ArrayList<>(3);

        Deque<NodeDepthPair> nodes = new ArrayDeque<>();
        nodes.push(new NodeDepthPair(treeRoot, 0));

        while (!nodes.isEmpty()) {

            // pop a node and its depth from the top of our stack
            NodeDepthPair nodeDepthPair = nodes.pop();
            TreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // case: we found a leaf
            if (node.left == null && node.right == null) {

                // we only care if it's a new depth
                if (!depths.contains(depth)) {
                    depths.add(depth);

                    // two ways we might now have an unbalanced tree:
                    //   1) more than 2 different leaf depths
                    //   2) 2 leaf depths that are more than 1 apart
                    if (depths.size() > 2 || (depths.size() == 2
                            && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }

                // case: this isn't a leaf - keep stepping down
            } else {
                if (node.left != null) {
                    nodes.push(new NodeDepthPair(node.left, depth + 1));
                }
                if (node.right != null) {
                    nodes.push(new NodeDepthPair(node.right, depth + 1));
                }
            }
        }

        return true;
    }

    @Test
    public void fullTreeTest() {
        final TreeNode root = new TreeNode(5);
        final TreeNode a = root.insertLeft(8);
        final TreeNode b = root.insertRight(6);
        a.insertLeft(1);
        a.insertRight(2);
        b.insertLeft(3);
        b.insertRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void bothLeavesAtTheSameDepthTest() {
        final TreeNode root = new TreeNode(3);
        root.insertLeft(4).insertLeft(1);
        root.insertRight(2).insertRight(9);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByOneTest() {
        final TreeNode root = new TreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void leafHeightsDifferByTwoTest() {
        final TreeNode root = new TreeNode(6);
        root.insertLeft(1);
        root.insertRight(0).insertRight(7).insertRight(8);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTest() {
        final TreeNode root = new TreeNode(1);
        root.insertLeft(5);
        final TreeNode b = root.insertRight(9);
        b.insertLeft(8).insertLeft(7);
        b.insertRight(5);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void bothSubTreesSuperbalancedTwoTest() {
        final TreeNode root = new TreeNode(1);
        final TreeNode a = root.insertLeft(2);
        a.insertLeft(3);
        a.insertRight(7).insertRight(8);
        root.insertRight(4).insertRight(5).insertRight(6).insertRight(9);
        final boolean result = isBalanced(root);
        assertFalse(result);
    }

    @Test
    public void onlyOneNodeTest() {
        final TreeNode root = new TreeNode(1);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    @Test
    public void treeIsLinkedListTest() {
        final TreeNode root = new TreeNode(1);
        root.insertRight(2).insertRight(3).insertRight(4);
        final boolean result = isBalanced(root);
        assertTrue(result);
    }

    public static void main(String[] args) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(PermutationPalindrome.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan testPlan = launcher.discover(request);
        launcher.registerTestExecutionListeners(listener);
        launcher.execute(request);

        listener.getSummary()
                .printTo(new PrintWriter(System.out));
    }
}
