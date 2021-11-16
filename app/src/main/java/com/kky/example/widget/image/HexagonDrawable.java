package com.kky.example.widget.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

/**
 * Author: Zeus
 * Date: 2021/5/31 10:28
 * Description: 六边形
 * History:
 */
public class HexagonDrawable extends Drawable {
    Rect mRect = new Rect();
    Paint mPaint;
    Path mPath;
    BitmapShader mShader;
    Bitmap mBitmap;

    public HexagonDrawable() {
        this(null);
    }

    public HexagonDrawable(Bitmap bitmap) {
        init();
        setBitmap(bitmap);
    }

    private void init() {
        initPaint();
        initPath();
    }

    private void initPaint() {
        ensurePaint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3f);
    }

    private void initPath() {
        ensurePath();
        float l = mRect.width() / 2;//变长
        float h = (float) Math.sqrt(3) * l;//高度
        float top = (mRect.height() - h) / 2;//六边形的顶部纵坐标
        mPath.reset();
        myPath(l, h, top);
//        othersPath(l, h, top);
        mPath.close();
    }

    private void othersPath(float l, float h, float top) {
        mPath.moveTo(l / 2, top);//左上，逆时针
        mPath.lineTo(0, h / 2 + top);//左中
        mPath.lineTo(l / 2, h + top);//左下
        mPath.lineTo((float) (l * 1.5), h + top);//右下
        mPath.lineTo(2 * l, h / 2 + top);//右中
        mPath.lineTo((float) (l * 1.5), top);//右上
        mPath.lineTo(l / 2, top);//
    }

    private void myPath(float l, float h, float top) {
        mPath.moveTo((l / 2), top);//左上1，接下来顺时针绘制
        mPath.lineTo((float) (1.5 * l), top);//右上
        mPath.lineTo(2 * l, h / 2 + top);//右中
        mPath.lineTo((float) (1.5 * l), h + top);//右下
        mPath.lineTo((l / 2), h + top);//左下
        mPath.lineTo(0, h / 2 + top);//左中
        mPath.lineTo(l / 2, top);//回到左上，完成闭合
    }

    private void ensurePaint() {
        if (mPaint == null) {
            mPaint = new Paint();
        }
    }

    private void ensurePath() {
        if (mPath == null) {
            mPath = new Path();
        }
    }

    private void setBitmap(Bitmap bitmap) {
        this.mBitmap = bitmap;
        if (bitmap == null) {
            mShader = null;
        } else {
            mShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            mPaint.setShader(mShader);
        }
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        if (mPaint != null) {
            mPaint.setAlpha(alpha);
        }
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        super.setBounds(left, top, right, bottom);
        mRect.set(left, top, right, bottom);
        initPath();
    }

    @Override
    public int getIntrinsicWidth() {
        if (mBitmap != null) {
            return mBitmap.getWidth();
        } else {
            return super.getIntrinsicWidth();
        }
    }

    @Override
    public int getIntrinsicHeight() {
        if (mBitmap != null) {
            return mBitmap.getHeight();
        } else {
            return super.getIntrinsicHeight();
        }
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (mPaint != null) {
            mPaint.setColorFilter(colorFilter);
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public int getOpacity() {
        return 0;
    }


}
