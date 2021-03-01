import java.util.*
import kotlinx.coroutines.*


@problemNumbers(num = 4)
fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
    for (columnIndex in matrix.indices) {
        for (rawIndex in matrix[columnIndex].indices) {
            if (target == matrix[columnIndex][rawIndex]) {
                return true
            }
            if (target < matrix[columnIndex][rawIndex]) {
                break
            }
        }
    }
    return false
}

@problemNumbers(num = 5)
fun replaceSpace(s: String): String {
    var result = ""
    for (item in s) {
        if (item == ' ') {
            result += "%20"
        } else {
            result += item
        }
    }
    return result
}

@problemNumbers(num = 6)
fun reversePrint(head: ListNode?): IntArray {
    val stack = Stack<Int>()
    var pointer = head
    while (true) {
        if (pointer != null) {
            stack.push(pointer.`val`)
        } else {
            break
        }
        pointer = pointer.next
    }
    val resultList = LinkedList<Int>()
    while (!stack.isEmpty()) {
        resultList.add(stack.pop())
    }
    return resultList.toIntArray()
}

@problemNumbers(num = 7)
fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {

    if (preorder.size == 0) {
        return null
    }

    if (preorder.size == 1) {
        return TreeNode(preorder[0])
    }

    var rootVal = preorder[0]
    var node = TreeNode(preorder[0])
    var rootIndexIn = -1
    for (index in 0 until inorder.size) {
        if (inorder[index] == rootVal) {
            rootIndexIn = index
            break
        }
    }
    if (rootIndexIn > 0) {
        node.left = buildTree(
                preorder.sliceArray(1..rootIndexIn),
                inorder.sliceArray(0..rootIndexIn - 1)
        )
    }

    if (rootIndexIn < inorder.size) {
        node.right = buildTree(
                preorder.sliceArray(rootIndexIn+1..preorder.size - 1),
                inorder.sliceArray(rootIndexIn+1..preorder.size -1 )
        )
    }

    return node
}

@problemNumbers(num = 9)
class CQueue() {

    var supportStack = Stack<Int>()
    var realStack = Stack<Int>()

    fun appendTail(value: Int) {
        for (i in 0 until realStack.size) {
            supportStack.push(realStack.pop())
        }
        realStack.push(value)
        for (i in 0 until supportStack.size) {
            realStack.push(supportStack.pop())
        }

    }

    fun deleteHead(): Int {
        if (realStack.isEmpty()) {
            return -1
        }
        return realStack.pop()
    }

}

@problemNumbers(num = 10)
fun fib(n: Int): Int {
    if (n == 0) {
        return 1
    }
    if (n == 1) {
        return 1
    }
    val fibArray = IntArray(n + 1)
    fibArray[0] = 0
    fibArray[1] = 1
    for (index in 2 until n + 1) {
        fibArray[index] = (fibArray[index - 1] + fibArray[index - 2]) % 1000000007
    }
    return fibArray[n]
}

fun numWays(n: Int): Int {
    if (n == 0) {
        return 0
    }
    if (n == 1) {
        return 1
    }
    val fibArray = IntArray(n + 1)
    fibArray[0] = 0
    fibArray[1] = 1
    for (index in 2 until n + 1) {
        fibArray[index] = (fibArray[index - 1] + fibArray[index - 2] + 2) % 1000000007
    }
    return fibArray[n]
}

fun minArray(numbers: IntArray): Int {
    val l = 0
    val r = numbers.size - 1
    val mid = (l+r) - 1
    val numberLeft = numbers.size
    while (numberLeft != 0) {
        if (numbers[mid] > numbers[mid + 1]) {
            return numbers[mid+1]
        } else if (numbers[mid] < numbers[mid - 1]) {
            return numbers[mid-1]
        } else {
            if (numbers[mid] > numbers[l]) {

            }

            if (numbers[mid] < numbers[l]) {

            }
        }
    }
    return -1
}

class Sword {

}

fun main() {
    
}

fun returnTest() = runBlocking {
    val result = launch {
        delay(500L)
    }
    delay(1000L)
    println("$result")
}

fun timeoutTest() = runBlocking {
    val result = withTimeout(1300L) {
        repeat(2) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done"
    }
    println("$result")
}


suspend fun doWorld() {
    delay(1000L)
}

fun cancelTest() = runBlocking(Dispatchers.Default) {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        try {
            var nextPrintTime = startTime
            var i = 0
            while (isActive) { // 可以被取消的计算循环
                // 每秒打印消息两次
                if (System.currentTimeMillis() >= nextPrintTime) {
                    println("job: I'm sleeping ${i++} ...")
                    nextPrintTime += 500L
                }
            }
        } finally {
            launch {
                println("job: I'm running finally")
                delay(10000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并等待它结束
    println("main: Now I can quit.")
}

annotation class problemNumbers(val num: Int)