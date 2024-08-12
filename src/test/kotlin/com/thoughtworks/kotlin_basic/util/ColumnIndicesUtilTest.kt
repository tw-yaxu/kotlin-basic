package com.thoughtworks.kotlin_basic.util

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ColumnIndicesUtilTest {
    private val columnIndicesUtil = ColumnIndicesUtil()

    @Test
    fun `1 and 1 to A`() {
        assertEquals(listOf("A"), columnIndicesUtil.getColumnLabelsFromConfig(1, 1))
    }

    @Test
    fun `1 and 2 to A, B`() {
        assertEquals(listOf("A", "B"), columnIndicesUtil.getColumnLabelsFromConfig(1, 2))
    }

    @Test
    fun `26 and 3 to Z, AA, AB`() {
        assertEquals(listOf("Z", "AA", "AB"), columnIndicesUtil.getColumnLabelsFromConfig(26, 3))
    }

    @Test
    fun `18278 to ZZZ`() {
        assertEquals(listOf("ZZZ"), columnIndicesUtil.getColumnLabelsFromConfig((26 * 26) * 26 + (26) * 26 + 26, 1))
    }

    @Test
    fun `throw error when start index is larger than 1378`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            columnIndicesUtil.getColumnLabelsFromConfig((26 * 26) * 26 + (26) * 26 + 26 + 1, 1)
        }
        assertEquals("Label should be smaller than ZZZ", exception.message)
    }
}