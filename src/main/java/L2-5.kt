class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    lateinit var last: ListNode
    var more = 0
    var node1 = l1
    var node2 = l2

    var node: ListNode = ListNode(l1!!.`val` + l2!!.`val`)
    if (node.`val` >= 10) {
        node.`val` %= 10
        more = 1
    }
    node1 = node1!!.next
    node2 = node2!!.next
    last = node

    while (true) {
        if (node1 == null && node2 == null) {
            break
        } else {
            // init
            if (node1 == null) {
                node1 = ListNode(0)
            }
            if (node2 == null) {
                node2 = ListNode(0)
            }
            // calculate new node
            var newNode = ListNode(node1.`val` + node2.`val` + more)
            if (newNode.`val` >= 10) {
                more = 1;
                newNode.`val` %= 10
            } else {
                more = 0
            }
            // change table
            node1 = node1.next
            node2 = node2.next
            last.next = newNode
            last = newNode
        }
    }
    if (more == 1) {
        last.next = ListNode(1)
    }
    return node
}

fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    var nowLength = 0
    var wordMap = HashMap<Char, Int>()
    for (checkIndex in 0 until s.length) {

        if (wordMap.containsKey(s[checkIndex])) {
            var lastWordIndex = wordMap[s[checkIndex]]
            nowLength = checkIndex - lastWordIndex!!
            wordMap.clear()
            for (charIndex in lastWordIndex + 1 until checkIndex + 1) {
                wordMap[s[charIndex]] = charIndex
            }
        } else {
            wordMap[s[checkIndex]] = checkIndex
            nowLength++
            if (nowLength >= result) {
                result = nowLength
            }
        }
    }

    return result
}

@failed
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    var result = 5.0
    var numLeftCount = nums1.size + nums2.size
    var l1 = 0
    var l2 = 0
    var r1 = nums1.size - 1
    var r2 = nums2.size - 1
    while (true) {
        var m1 : Int = ((l1 + r1)/ 2)
        var m2 : Int = ((l2 + r2)/ 2)

        if (r1 - l1 >= 1) {
            m1 += 1
        } else if (r2 - l2 >= 1) {
            m2 += 1
        }

        if (nums1[m1] > nums2[m2]) {
            numLeftCount = numLeftCount - r1 + m1 - m2 + l2
            r1 = m1
            l2 = m2
        } else if (nums1[m1] < nums2[m2]) {
            numLeftCount = numLeftCount - r2 + m2 - m1 + l1
            l1 = m1
            r2 = m2
        } else {
            result = nums1[m1].toDouble()
            break
        }

        if (numLeftCount <= 2) {
            result = (nums1[m1].toDouble() + nums2[m2].toDouble())/2
            break
        }
    }

    return result
}

fun main() {
    print(findMedianSortedArrays(intArrayOf(1,3), intArrayOf(2)))
}

@Target(AnnotationTarget.FUNCTION)
annotation class failed
