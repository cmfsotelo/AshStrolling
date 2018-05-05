package com.example.csotelo.ashstrolling.core

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import java.util.*

class Ash {
    private val position = Point()

    fun moveInGraphicPath(pathString: String): Path {
        val path = Path()
        val pAux = pathString.toLowerCase()
        for (c in pAux.toCharArray()) {
            moveInDirection(c)
            path.lineTo(position.x.toFloat(), position.y.toFloat())
        }
        val c = Canvas()
        c.drawPath(path, Paint())
        val bounds = c.clipBounds
        val b = Bitmap.createBitmap(bounds.top - bounds.bottom, bounds.right - bounds.left, Bitmap.Config.RGB_565)

        return path
    }

    fun catchPokemonInPath(path: String): Int {
        val visitedPositions = HashSet<String>()
        visitedPositions.add(position.toString())
        val pAux = path.toLowerCase()
        for (c in pAux.toCharArray()) {
            moveInDirection(c)
            visitedPositions.add(position.toString())
        }
        return visitedPositions.size
    }

    fun moveInDirection(direction: Char) {
        when (direction) {
            'n' -> position.y++
            's' -> position.y--
            'e' -> position.x++
            'o', 'w' -> position.x--
        }
    }

}
