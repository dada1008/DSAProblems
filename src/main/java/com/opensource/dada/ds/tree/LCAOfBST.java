package com.opensource.dada.ds.tree;

public class LCAOfBST {
    public static void main(String[] args) {

    }

    static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root,
                                                  TreeNode<Integer> p, TreeNode<Integer> q) {
        TreeNode<Integer> m = root;

        if(m.value > p.value && m.value < q.value){
            return m;
        }else if(m.value>p.value && m.value > q.value){
            return lowestCommonAncestor(root.left, p, q);
        }else if(m.value<p.value && m.value < q.value){
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;

    }
}
