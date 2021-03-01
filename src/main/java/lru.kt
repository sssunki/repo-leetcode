class LRUCache(val capacity: Int) {

    var lruTableHead = LRUNode(0,0)
    var lruTableTail = LRUNode(0, 0)

    inner class LRUNode(var keyValue: Int, var `val`: Int) {
        lateinit var next: LRUNode
        lateinit var ahead: LRUNode
    }

    var map = HashMap<Int, LRUNode>()

    fun get(key: Int): Int {
        var nodeResult = map.get(key) ?: return -1
        moveToHead(nodeResult)
        return nodeResult.`val`
    }


    // synchronized
    fun put(key: Int, value: Int) {
        if (map.isEmpty()) {
            lruTableHead.next = lruTableTail
            lruTableTail.ahead = lruTableHead
        }
        if (map.containsKey(key)) {
            map[key]!!.`val` = value
            moveToHead(map[key]!!)
        } else {
            if (map.size == capacity) {
                removeTail()
            }
            var newNode = LRUNode(key, value)
            map.put(key, newNode)
            addToHead(newNode)
        }
    }

    fun remove(node: LRUNode) {
        node.ahead.next = node.next
        node.next.ahead = node.ahead
    }

    fun moveToHead(node: LRUNode) {
        remove(node)
        addToHead(node)
    }

    fun addToHead(newHead: LRUNode) {
        newHead.next = lruTableHead.next
        newHead.ahead = lruTableHead
        lruTableHead.next.ahead = newHead
        lruTableHead.next = newHead
    }

    fun removeTail() {
        map.remove(lruTableTail.ahead.keyValue)
        lruTableTail.ahead = lruTableTail.ahead.ahead
        lruTableTail.ahead.next = lruTableTail
    }
}

fun lruTest() {
    val cache = LRUCache( 2 /* 缓存容量 */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);
}