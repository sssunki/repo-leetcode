import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    var result = LinkedList<Int>()
    midTraversal(root, result)
    return result
}

fun midTraversal(node: TreeNode?, list: LinkedList<Int>) {
    if (node == null) {
        return
    }
    // 前序，后序遍历调整 list.add 位置即可
    // 对应 leetcode 144 145
    midTraversal(node.left, list)
    list.add(node.`val`)
    midTraversal(node.right, list)
}