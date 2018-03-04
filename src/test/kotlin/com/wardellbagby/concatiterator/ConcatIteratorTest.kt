package com.wardellbagby.concatiterator

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test

class ConcatIteratorTest {

    @Test
    fun testConcatIterator() {
        var iterator = ConcatIterator((0 until 10), (0 until 0), (10 until 20), (0 until 0), (20 downTo 1))
        assertEquals((0 until 10).toList(), iterator.asSequence().take(10).toList())

        iterator = ConcatIterator((0 until 10), (0 until 0), (10 until 20), (0 until 0), (20 downTo 1))
        assertEquals((10 until 20).toList(), iterator.asSequence().drop(10).take(10).toList())

        iterator = ConcatIterator((0 until 10), (0 until 0), (10 until 20), (0 until 0), (20 downTo 1))
        assertEquals((20 downTo 1).toList(), iterator.asSequence().drop(20).take(20).toList())

        iterator = ConcatIterator((0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 0),
                (0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 0), (0 until 10))
        assertEquals((0 until 10).toList(), iterator.asSequence().toList())
    }

    @Test(expected = NoSuchElementException::class)
    fun testNoSuchElement() {
        val iterator = ConcatIterator(0 until 0)
        assertFalse(iterator.hasNext())
    }
}