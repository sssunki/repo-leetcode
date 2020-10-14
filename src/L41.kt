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