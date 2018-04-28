package com.example.csotelo.ashstrolling.core;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

import java.util.HashSet;

public class Ash {
    private Point position = new Point();

    public Path moveInGraphicPath(String pathString) {
        Path path = new Path();
        String pAux = pathString.toLowerCase();
        for (char c : pAux.toCharArray()) {
            moveInDirection(c);
            path.lineTo(position.x, position.y);
        }
        Canvas c = new Canvas();
        c.drawPath(path, new Paint());
        Rect bounds = c.getClipBounds();
        Bitmap b = Bitmap.createBitmap(bounds.top - bounds.bottom, bounds.right - bounds.left, Bitmap.Config.RGB_565);

        return path;
    }

    public int moveInPath(String path) {
        HashSet<String> visitedPositions = new HashSet<>();
        visitedPositions.add(position.toString());
        String pAux = path.toLowerCase();
        for (char c : pAux.toCharArray()) {
            moveInDirection(c);
            visitedPositions.add(position.toString());
        }
        return visitedPositions.size();
    }

    public void moveInDirection(char direction) {
        switch (direction) {
            case 'n':
                position.y++;
                break;
            case 's':
                position.y--;
                break;
            case 'e':
                position.x++;
                break;
            case 'o':
                position.x--;
                break;
            default:
        }
    }

}
