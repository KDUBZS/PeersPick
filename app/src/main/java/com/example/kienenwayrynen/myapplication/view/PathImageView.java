package com.example.kienenwayrynen.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;

public class PathImageView extends AppCompatImageView{

    private List<Point> path;
    private Paint pathPaint;

    public PathImageView(Context context) {
        super(context);
    }

    public PathImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setMap(Bitmap mapImage, List<Point> path) {
        Canvas canvas = new Canvas(mapImage);
        for (int i = 1; i < path.size(); i++) {
            Point cur = path.get(i);
            Point last = path.get(i-1);
            if (pathPaint == null) {
                pathPaint = new Paint();
                pathPaint.setColor(Color.RED);
                pathPaint.setStrokeWidth(8.0f);
            }
            canvas.drawLine(last.x, last.y, cur.x, cur.y, pathPaint);
        }
        setImageBitmap(mapImage);
    }


}
