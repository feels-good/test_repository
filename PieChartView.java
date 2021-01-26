package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.os.DropBoxManager;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.MutableInt;
import android.view.View;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class PieChartView extends View {

    private Float startAngle = 0.0f;

    public PieChartView(Context context) {
        super(context);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        Map<Float, String> map = new HashMap<>();
        map.put(90.0f, "25%");
        map.put(90.0f, "25%");
        map.put(90.0f, "25%");
        map.put(90.0f, "25%");
//        createArc(canvas, map, 100);
        float startAngle = 22.5f;
        float sweepAngle = 45.0f;
        String text = "25%";
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FFF44336"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FFE91E63"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FF9C27B0"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FF3F51B5"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FF03A9F4"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FF009688"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FF8BC34A"));
        startAngle += sweepAngle;
        createArc(canvas, map, startAngle, sweepAngle, text, Color.parseColor("#FFFFC107"));


    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void createArc(Canvas canvas, Map<Float, String> map, int radius) {
        final float centerX = 200 + radius;
        final float centerY = 200 + radius;
        final float line1 = radius * 0.3f;
        ((Runnable) () -> {
            for (Map.Entry<Float, String> entry : map.entrySet()) {
                float sweepAngle = entry.getKey();
                String text = entry.getValue();
                Double y = Math.sin((startAngle + sweepAngle / 2) * Math.PI / 180);
                Double x = Math.cos((startAngle + sweepAngle / 2) * Math.PI / 180);
                Paint paint2 = new Paint();
                Paint paint = new Paint();
                Paint paint1 = new Paint();
                Path path = new Path();
                Path path1 = new Path();
                paint2.setStyle(Paint.Style.STROKE);
                paint2.setColor(Color.RED);
                paint1.setAntiAlias(true);
                paint1.setStrokeWidth(5);
                paint1.setStyle(Paint.Style.STROKE);
                paint1.setColor(Color.WHITE);
                paint.setAntiAlias(true);
                paint.setColor(Color.RED);
                path.addArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, startAngle, sweepAngle);
                path.lineTo(centerX, centerY);
                canvas.drawPath(path, paint);
                if (x >= 0) {
                    path1.moveTo(centerX + radius * 0.9f * x.floatValue(), centerY + radius * 0.9f * y.floatValue());
                    path1.rLineTo(line1 * x.floatValue(), line1 * y.floatValue());
                    path1.rLineTo(radius, 0);
                    canvas.drawPath(path1, paint1);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize(20);
                    canvas.drawTextOnPath(text, path1, radius, -10, paint);
                } else {
                    path1.moveTo(centerX + radius * 0.9f * x.floatValue(), centerY + radius * 0.9f * y.floatValue());
                    path1.rLineTo(line1 * x.floatValue(), line1 * y.floatValue());
                    path1.rLineTo(-radius, 0);
                    canvas.drawPath(path1, paint1);
                    paint.setColor(Color.BLACK);
                    paint.setTextSize(20);
                    paint.setTextAlign(Paint.Align.LEFT);
                    float textX = centerX + (radius + line1) * x.floatValue() - radius;
                    float textY;
                    float v = centerY + (radius + line1) * y.floatValue();
                    if (y >= 0) {
                        textY = v - 15;
                    } else textY = v;
                    canvas.drawText(text, textX, textY, paint);
                }
                startAngle += sweepAngle;
            }
        }).run();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void createArc(Canvas canvas, Map map, Float startAngle, Float sweepAngle, String text, int color) {
        Double y = Math.sin((startAngle + sweepAngle / 2) * Math.PI / 180);
        Double x = Math.cos((startAngle + sweepAngle / 2) * Math.PI / 180);
        Paint paint2 = new Paint();
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        Path path = new Path();
        Path path1 = new Path();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(Color.RED);
        paint1.setAntiAlias(true);
        paint1.setStrokeWidth(5);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.WHITE);
        paint.setAntiAlias(true);
        paint.setColor(color);
        path.addArc(200, 200, 400, 400, startAngle, sweepAngle);
        path.lineTo(300, 300);
        canvas.drawPath(path, paint);
        if (x >= 0) {
            path1.moveTo(300 + 90 * x.floatValue(), 300 + 90 * y.floatValue());
            path1.rLineTo(30 * x.floatValue(), 30 * y.floatValue());
            path1.rLineTo(100, 0);
            canvas.drawPath(path1, paint1);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            canvas.drawTextOnPath(text, path1, 100, -10, paint);
        } else {
            path1.moveTo(300 + 90 * x.floatValue(), 300 + 90 * y.floatValue());
            path1.rLineTo(30 * x.floatValue(), 30 * y.floatValue());
            path1.rLineTo(-100, 0);
            canvas.drawPath(path1, paint1);
            paint.setColor(Color.BLACK);
            paint.setTextSize(20);
            paint.setTextAlign(Paint.Align.LEFT);
            float textX = 300 + 120 * x.floatValue() - 100;
            float textY = 300 + 120 * y.floatValue() - 10;
            canvas.drawText(text, textX, textY, paint);
        }
    }
}
