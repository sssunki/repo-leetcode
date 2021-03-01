fun findRepeatNumber(nums: IntArray): Int {
    var result = IntArray(nums.size)
    for (num in nums) {
        if (result[num] == 1) {
            return num
        } else {
            result[num] = 1
        }
    }
    return -1
}

fun sumZero(n: Int) : IntArray {
    var result = IntArray(n)
    var index = -1
    var addNum = 0
    for (i in 0 until n) {
        result[i] = addNum * index
        if (index == -1) {
            addNum++
        }
        index *= -1
    }
    if (n > 0 && result[n - 1] > 0) {
        result[0] = result[n - 1] * -1
    }
    return result
}

fun main() {
//    print(findRepeatNumber(intArrayOf(2,3,1,0,2,5,3)))
    for (item in sumZero(1)) {
        print("$item, ")
    }
}