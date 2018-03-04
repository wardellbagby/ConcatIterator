package com.wardellbagby.concatiterator

class ConcatIterator<T>(private vararg val iterators: Iterator<T>) : Iterator<T> {

    constructor(vararg iterables: Iterable<T>) : this(*(iterables.map { it.iterator() }.toTypedArray()))

    private var index = 0

    override fun hasNext(): Boolean {
        if (iterators.isEmpty()) return false
        val nextIndex = iterators.drop(if (index < 0) 0 else index).indexOfFirst { it.hasNext() }
        index = if (nextIndex > -1) nextIndex + index else -1
        return index > -1 && index < iterators.size
    }

    override fun next(): T {
        if (hasNext()) return iterators[index].next()
        throw NoSuchElementException()
    }

}

operator fun <T> Iterator<T>.plus(other: Iterator<T>): Iterator<T> = ConcatIterator(this, other)
operator fun <T> Iterator<T>.plus(other: Iterable<T>): Iterator<T> = ConcatIterator(this, other.iterator())