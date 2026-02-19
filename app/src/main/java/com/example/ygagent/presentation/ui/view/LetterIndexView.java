package com.example.ygagent.presentation.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class LetterIndexView extends View {

    public static final String[] LETTERS = {
            "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R",
            "S", "T", "U", "V", "W", "X", "Y", "Z", "#"
    };

    private Paint paint;
    private int itemHeight; // 每个字母占用的高度
    private int currentIndex = -1; // 当前选中的字母索引

    // 字母选择监听器
    private OnLetterSelectedListener listener;

    public interface OnLetterSelectedListener {
        void onLetterSelected(String letter);
    }

    public LetterIndexView(Context context) {
        this(context, null);
    }

    public LetterIndexView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LetterIndexView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.parseColor("#666666")); // 默认灰色
        paint.setTextSize(dp2px(14)); // 字母大小
        paint.setTextAlign(Paint.Align.CENTER); // 居中对齐
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        // 计算每个字母的高度
        itemHeight = height / LETTERS.length;
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        for (int i = 0; i < LETTERS.length; i++) {
            String letter = LETTERS[i];
            // 计算每个字母的基线 y 坐标（居中显示）
            float y = i * itemHeight + itemHeight / 2f + getBaselineOffset(paint);
            // 如果是当前选中字母，高亮显示
            if (i == currentIndex) {
                paint.setColor(Color.parseColor("#FF4081")); // 高亮颜色
            } else {
                paint.setColor(Color.parseColor("#666666"));
            }
            canvas.drawText(letter, width / 2f, y, paint);
        }
    }

    // 计算文本绘制的基线偏移量（因为 drawText 的 y 坐标是基线位置）
    private float getBaselineOffset(Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();
        return (fm.descent - fm.ascent) / 2 - fm.descent;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float y = event.getY();
        int index = (int) (y / itemHeight);
        if (index < 0) index = 0;
        if (index >= LETTERS.length) index = LETTERS.length - 1;

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                setCurrentIndex(index);
                if (listener != null) {
                    listener.onLetterSelected(LETTERS[index]);
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                // 抬起手指，取消高亮
                setCurrentIndex(-1);
                break;
        }
        return true; // 消费事件
    }

    private void setCurrentIndex(int index) {
        if (currentIndex != index) {
            currentIndex = index;
            invalidate(); // 重绘
        }
    }

    public void setOnLetterSelectedListener(OnLetterSelectedListener listener) {
        this.listener = listener;
    }

    private int dp2px(float dp) {
        return (int) (dp * getResources().getDisplayMetrics().density + 0.5f);
    }
}
