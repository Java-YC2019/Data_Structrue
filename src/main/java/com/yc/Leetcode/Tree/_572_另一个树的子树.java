package com.yc.Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class _572_另一个树的子树 {
   public boolean isSubtree(TreeNode s, TreeNode t) {
        return (isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
   }


    //还要一个方法判断两棵树是否一样
    public boolean isSame(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
//        if (s == null || t == null){
//            if (s.val != t.val) return false;
//            return (isSame(s.left,t.left) && isSame(s.right,t.right));
//        }
//        return false;
        //d调用递归最好把递归写最后
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return (isSame(s.left, t.left) && isSame(s.right, t.right));
    }

    //判断两棵树是否一样的时候，按照上述的判断的话，比如说s的left已经和t的left不相等，这时就可以结束判断，
//但是s的right还会继续判断下去。假如s的right和t的right非常长且相等，那么会做很多无效判断，
// 所以只要一边返回true,就可以终止判断该节点
//    public boolean isSame(TreeNode s, TreeNode t, boolean flag) {
//        //flag只要是false，直接终止判断
//        if (s == null && t == null) return true;
//        if (s == null || t == null) return false;
//        if (s.val == t.val) {
//            return (isSame(s.left, t.left, true)
//                    && isSame(s.right, t.right, true));
//        } else {
//            if (flag) return false;
//            else return isSame(s.left, t.left, false) || isSame(s.right, t.right, false);
//        }
//
//    }

    public boolean isSubtree1(TreeNode s, TreeNode t) {
        return isSame(s, t, false);
    }

    //增加一个flag作为是否已经判断过的标志。
    public boolean isSame(TreeNode s, TreeNode t, boolean flag) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val == t.val) {
            return (isSame(s.left, t.left, true)
                    && isSame(s.right, t.right, true))

                    || isSame(s.left, t, false)

                    || isSame(s.right, t, false);
        } else {
            if (flag) return false;
            else return isSame(s.left, t, false) || isSame(s.right, t, false);
        }
    }

}