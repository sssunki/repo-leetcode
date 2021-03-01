/**
 * Leetcode 41 题目：给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数
 * 输入为长度为n的数组里面，结果应该在 1..n+1 范围内
 * 思路为原地哈希
 * 当结果为 n + 1 时，前面 1..n 正好可以放在数组里，其他情况，从0开始第一个确实的单位的下标 + 1，就是没有出现的最小正整数
 */

class L41 {
    companion object {
        fun firstMissingPositive(nums: IntArray): Int {
            for (i in 0..(nums.size - 1)) {
                while (true) {
                    if (nums[i] > nums.size || nums[i] <= 0) {
                        break
                    }

                    if (i + 1 == nums[i]) {
                        break
                    }

                    var temp = nums[i]
                    if (temp == nums[temp - 1]) {
                        break
                    }
                    nums[i] = nums[temp - 1]
                    nums[temp - 1] = temp
                }
            }

            for (i in 0..(nums.size - 1)) {
                if (nums[i] != i + 1) {
                    return i + 1;
                }
            }
            return nums.size + 1
        }

    }
}

fun main() {
    val nums = intArrayOf(1, 1)
    print(
            L41.firstMissingPositive(nums)
    )
}