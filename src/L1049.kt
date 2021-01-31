import kotlin.concurrent.fixedRateTimer
import kotlin.math.max

/**
 * 动态规划，背包问题
 * 2021 1 31
 */

fun lastStoneWeightII(stones: IntArray): Int {
    var all = 0
    for (item in stones) {
        all += item
    }
    val dpSize = (all/2).toInt()

    var dp = IntArray(dpSize + 1)

    // 不需要初始化dp数组，因为kotlin会自动初始化为0

    for (i in 0 until stones.size) {
        for (j in dpSize downTo 0 step 1) {
            if (j - stones[i] < 0) {
                break
            }
            dp[j] = max(dp[j], dp[j - stones[i]] + stones[i])
        }
    }

    var result = all - dp[dpSize] - dp[dpSize]

    return result
}

fun max(a: Int, b: Int) : Int {
    if (a >= b) {
        return a
    } else {
        return b
    }
}

fun main() {
    print(lastStoneWeightII(intArrayOf(2, 7, 1, 4, 8, 1)))
}