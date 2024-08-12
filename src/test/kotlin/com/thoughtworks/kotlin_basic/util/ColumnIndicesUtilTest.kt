package com.thoughtworks.kotlin_basic.util

import kotlin.test.Test

class ColumnIndicesUtilTest {
    @Test
    fun `1 to A`() {
        val columnIndicesUtil = ColumnIndicesUtil()
        assert(columnIndicesUtil.getColumnLabelByIndex(1) == "A")
    }
}