package com.thoughtworks.kotlin_basic.util

import java.lang.StringBuilder

// 1 -> A, 2 -> B, 26 -> Z
// 27 -> AA, 28 -> AB, ..., 52 -> AZ
// 53 -> BA, 54 -> BB, ..., 78 -> BZ
// 26^1 * 2 + 26^0 * 1 = 52 + 1 = 53
// 26^2 * 26 + 26^1 * 26 + 26^0 * 26 =

class ColumnIndicesUtil {
    companion object {
        const val ALPHABET_COUNT = 26
        const val LARGEST_COLUMN_INDEX = (26 * 26) * 26 + (26) * 26 + 26
    }

    private fun getColumnLabelByIndex(columnNumber: Int): String {
        if (columnNumber > LARGEST_COLUMN_INDEX) {
            throw IllegalArgumentException("Label should be smaller than ZZZ")
        }

        val result = StringBuilder()
        var temp = columnNumber

        while (temp > 0) {
            temp --
            val remainder = temp % ALPHABET_COUNT
            result.append('A' + remainder)
            temp /= ALPHABET_COUNT
        }
        return result.reverse().toString()
    }

    fun getColumnLabelsFromConfig(startIndex: Int, count: Int): List<String> {
        return (startIndex..< startIndex  + count).map { getColumnLabelByIndex(it) }
    }
}