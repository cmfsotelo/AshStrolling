package com.example.csotelo.ashstrolling.utils

import java.util.*

object Utils {
    private val TWO_ZEROS = "00"
    private val ONE_ZERO = "0"

    fun toThreeDigitNumber(n: Int): String {
        if (n >= 1 && n <= 9)
            return TWO_ZEROS + n
        return if (n <= 99) ONE_ZERO + n else n.toString()
    }

    fun randomInt(max: Int, min: Int = 0): Int {
        val r = Random()
        return r.nextInt(max - min + 1) + min
    }

    fun randomIntList(max: Int, min: Int = 0, count: Int = 1): List<Int> {
        return IntArray(count).map { randomInt(max, min) }
    }
}
