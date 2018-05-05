package com.example.csotelo.ashstrolling.core

class Point(internal var x: Long = 0, internal var y: Long = 0) {


    @Throws(CloneNotSupportedException::class)
    protected fun clone(): Any {
        return Point(x, y)
    }

    override fun toString(): String {
        return "$x,$y"
    }
}
