/**
 * leetcode 76 : 给定两个单词，算出单词一变化到单词二的最少步数
 * 动态规划，最长子序列长度 +
 */
class Solution76 {

    var LCSLength = IntArray(100)

    fun calculateLCSLength(word1: String, word2: String, i: Int, j: Int) : Int {
        if (word1[i].equals(word2[j])) {
            LCSLength[i] = calculateLCSLength(word1, word2, i - 1, j - 1) + 1
        } else {
            LCSLength[i] = max(
                    calculateLCSLength(word1, word2, i - 1, j),
                    calculateLCSLength(word1, word2, i, j - 1)
            )
        }
        return 0
    }

    fun max(i: Int, j: Int) : Int {
        if (i >= j) {
            return i
        } else {
            return j
        }
    }

    fun minDistance(word1: String, word2: String): Int {
        var result = 0

        return result
    }
}

fun main() {
    print(Solution76().minDistance("horse", "ros"))
}

