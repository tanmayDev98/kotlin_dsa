package stacks

//stack follows first in last out
class BasicIntStack() {
    private val _items: MutableList<Int> = mutableListOf()
    private var top: Int = -1

    fun push(item: Int) {
        _items.add(item)
        top += 1
    }

    fun pop() {
        if(top == -1)
            return
        _items.removeAt(top)
        top -= 1
    }

    fun top(): Int {
        if(top == -1)
            return -1
        return _items[top]
    }

    fun size(): Int {
        return _items.size
    }

    fun print() {
        println(_items)
    }
}

class IntStack() {
    private val _items: MutableList<Int> = mutableListOf()

    fun push(item: Int) {
        _items.add(item)
    }

    fun pop() {
        _items.removeLast()
    }

    fun size(): Int {
        return _items.size
    }

    fun top(): Int? {
        return _items.lastOrNull()
    }

    fun isEmpty(): Boolean {
        return _items.isEmpty()
    }

    fun print() {
        println(_items)
    }
}

class Stack<T> {
    private val _items: MutableList<T> = mutableListOf()

    fun push(item: T) {
        _items.add(item)
    }

    fun pop(): T?  {
        return _items.removeLastOrNull()
    }

    fun top() : T? {
        return _items.lastOrNull()
    }

    fun size() : Int {
        return _items.size
    }

    fun display() {
        println(_items)
    }
}