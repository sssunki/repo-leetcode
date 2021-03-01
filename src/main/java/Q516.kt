import java.util.*

fun findDiagonalOrder(nums: List<List<Int>>): IntArray {
    var i = LinkedList<Int>()
    var numsListIndex = 0
    var eof = true
    while (true) {
        for (numsIndex in numsListIndex downTo 0 step 1) {
            var rawIndex = numsListIndex - numsIndex
            if (numsIndex >= nums.size) {
                numsIndex.downTo(nums.size)
                continue
            }
            if (rawIndex >= nums[numsIndex].size) {
                continue
            } else {
                i.add(nums[numsIndex][rawIndex])
                eof = false
            }
        }
        if (eof) {
            break
        }
        eof = true
        numsListIndex++
    }

    return i.toIntArray()
}

fun solution2(nums: List<List<Int>>): IntArray {
    var result = LinkedList<LinkedList<Int>>()
    for (listIndex in 0 until nums.size) {
        for (numIndex in 0 until nums[listIndex].size) {
            if (numIndex + listIndex >= result.size) {
                result.add(LinkedList())
            }
            result[numIndex + listIndex].add(nums[listIndex][numIndex])
        }
    }
    var returnNums = LinkedList<Int>()
    for (item in result) {
        for (index in item.size - 1 downTo 0 step 1) {
            returnNums.add(item[index])
        }
    }
    return returnNums.toIntArray()
}

fun main() {
    val param = listOf<List<Int>>(listOf(1,2,3), listOf(4,5,6), listOf(7,8,9))
    var params = solution2(param)
    for (i in params) {
            print("$i ")
    }
}
