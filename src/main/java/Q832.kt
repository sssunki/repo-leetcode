fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
    for (array in A) {
        for (i in 0 until (array.size - 1)/2 + 1) {
            val temp = array[array.size - 1 - i]
            array[array.size - 1 - i] = if (array[i] == 1) 0 else 1
            array[i] = if (temp == 1) 0 else 1
        }
    }
    return A
}

fun main() {
    val arrays = flipAndInvertImage(
            arrayOf(intArrayOf(1,1,0,0),
                    intArrayOf(1,0,0,1),
                    intArrayOf(0,1,1,1),
                    intArrayOf(1,0,1,0)))
    println(arrays[0][0])
    for (array in arrays) {
        for (item in array) {
            print(item)
        }
        println()
    }
}