package com.thoughtworks.kotlin_basic.util

import java.lang.StringBuilder

// 1 -> A, 2 -> B, 26 -> Z
// 27 -> AA, 28 -> AB, ..., 52 -> AZ
// 53 -> BA, 54 -> BB, ..., 78 -> BZ
// 26^1 * 2 + 26^0 * 1 = 52 + 1 = 53

class ColumnIndicesUtil {
    private fun getColumnLabelByIndex(columnNumber: Int): String {
        val result = StringBuilder()
        var temp = columnNumber

        while (temp > 0) {
            temp --
            val remainder = temp % 26
            result.append('A' + remainder)
            temp /= 26
        }
        return result.reverse().toString()
    }

    fun getColumnLabelsFromConfig(startIndex: Int, count: Int): List<String> {
        return (startIndex..< startIndex  + count).map { getColumnLabelByIndex(it) }
    }
}