package queues

class Queue<T> {
    private var _items: MutableList<T> = mutableListOf()

    fun enqueue(element: T) {
        _items.add(element)
    }

    fun dequeue() : T? {
        return if(_items.isEmpty())
            null
        else
            _items.removeAt(0)
    }

    fun size() : Int {
        return _items.size
    }

    fun isEmpty() : Boolean {
        return _items.isEmpty()
    }

    fun printQueue() {
        println(_items)
    }
}