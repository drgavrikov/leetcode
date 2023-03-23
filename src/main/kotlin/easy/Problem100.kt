package easy

import TreeNode

/**
 * @author Aleksandr Gavrikov
 * @url https://leetcode.com/problems/single-number/
 */
class Problem100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        fun dfs(p: TreeNode?, q: TreeNode?): Boolean {
            if (p == null && q == null) return true
            if (p == null || q == null) return false
            if (p.`val` != q.`val`) return false
            return dfs(p.left, q.left) && dfs(p.right, q.right)
        }
        return dfs(p, q)
    }
}
