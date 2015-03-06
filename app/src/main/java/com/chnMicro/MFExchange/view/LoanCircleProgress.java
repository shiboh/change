package com.chnMicro.MFExchange.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.chnMicro.MFExchange.R;

/**
 * Created by Enel on 2015/3/6.
 */
public class LoanCircleProgress extends View {
    private Integer max;    //最大进度
    private Integer progress;   //当前进度
    private Integer progressColor;  //进度条颜色
    private Integer secondaryColor; //进度条背景颜色
    private Integer status; //标的状态（0-投资中,1-已满标,2-还款中,3-已结清）
    private float stokeWidthRatio;  //进度条线宽占整个圆半径的比例
    private Paint circlePaint;
    private TextPaint textPaint;

    RectF rectF = new RectF();  //画进度view的范围
    private float strokeWidth;

    public LoanCircleProgress(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        Context context = getContext();
        Resources resources = getResources();

        //TODO: change default value
        max = 100;
        progress = 0;
        progressColor = resources.getColor(R.color.mifie_red);
        secondaryColor = resources.getColor(R.color.grey_bg);
        stokeWidthRatio = 0.15f;
        status = 0;
        initPaints();

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoanCircleProgress);
        max = a.getInt(R.styleable.LoanCircleProgress_max, max);
        progress = a.getInt(R.styleable.LoanCircleProgress_progress, progress);
        progressColor = a.getColor(R.styleable.LoanCircleProgress_color_progress, progressColor);
        secondaryColor = a.getColor(R.styleable.LoanCircleProgress_color_secondary, secondaryColor);
        status = a.getInt(R.styleable.LoanCircleProgress_status, status);
        a.recycle();
    }

    private void initPaints() {
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(progressColor);
        circlePaint.setStyle(Paint.Style.STROKE);

        textPaint = new TextPaint();
        textPaint.setTextAlign(Paint.Align.CENTER);
        //TODO
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Integer measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        Integer measureHeight = MeasureSpec.getSize(heightMeasureSpec);

        strokeWidth = measureWidth / 2 * stokeWidthRatio;
        circlePaint.setStrokeWidth(strokeWidth);    //按比例计算线宽之后，需要在measure之后，所以写到这里
        rectF.set(strokeWidth / 2f, strokeWidth / 2f, measureWidth - strokeWidth / 2f, measureHeight - strokeWidth / 2f);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    @Override protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int contentWidth = getWidth() - paddingLeft - paddingRight;
        int contentHeight = getHeight() - paddingTop - paddingBottom;

        //画进度条
        float startAngle = -90;
        float sweepAngle = 100;
        circlePaint.setColor(progressColor);
        canvas.drawArc(rectF, startAngle, sweepAngle, false, circlePaint);
        circlePaint.setColor(secondaryColor);
        canvas.drawArc(rectF, startAngle + sweepAngle, 360 + startAngle, false, circlePaint);
        //TODO:写字
        //标的状态（0-投资中,1-已满标,2-还款中,3-已结清）

        switch (status) {
            case 0:

                break;

            default:
                break;
        }

    }
}
