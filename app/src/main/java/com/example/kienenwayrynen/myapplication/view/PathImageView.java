package com.example.kienenwayrynen.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

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

    public void setPath(List<Point> path) {
        this.path = path;
        invalidate();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (path != null) {
            if (pathPaint == null) {
                pathPaint = new Paint();
                pathPaint.setColor(Color.RED);
                pathPaint.setStrokeWidth(8.0f);
            }
            for (int i = 0 ; i < path.size(); i++) {
                if (i != 0) {
                    Point start = path.get(i);
                    Point end = path.get(i-1);
                    canvas.drawLine(start.x, start.y, end.x, end.y, pathPaint);
                }
            }
        }
    }
}
