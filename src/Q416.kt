/**
 * 动态规划，背包问题
 * 2021 1 31
 * 和1049题基本一致
 */
fun canPartition(nums: IntArray) : Boolean {
    var all = 0
    for (item in nums) {
        all += item
    }
    val dpSize = (all/2).toInt()

    if (dpSize * 2 != all) {
        return false
    }

    var dp = IntArray(dpSize + 1)

    // 不需要初始化dp数组，因为kotlin会自动初始化为0

    for (i in 0 until nums.size) {
        for (j in dpSize downTo 0 step 1) {
            if (j - nums[i] < 0) {
                break
            }
            dp[j] = max2(dp[j], dp[j - nums[i]] + nums[i])
        }
    }

    var result = all - dp[dpSize] - dp[dpSize]

    return result == 0
}

fun max2(a: Int, b: Int) : Int {
    if (a >= b) {
        return a
    } else {
        return b
    }
}

fun main() {
    print(
            canPartition(intArrayOf(1,5,11,2))
    )
}