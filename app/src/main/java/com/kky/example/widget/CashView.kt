package com.kky.example.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/*
* @author Zeus
* create at 2019/4/13 17:51
* modify at 2019/4/13 17:51
* modify because 
* description: 自定义view流程
*/
class CashView : View {

    //1--构造函数--初始化
    //一般在直接New一个View的时候调用。
    constructor(context: Context?) : super(context)

    //一般在layout文件中使用的时候会调用，关于它的所有属性(包括自定义属性)都会包含在attrs中传递进来。
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    //即使你在View中使用了Style这个属性也不会调用三个参数的构造函数，所调用的依旧是两个参数的构造函数。
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //2--测量View的大小
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        //widthMeasureSpec 和 heightMeasureSpec 这两个 int 类型的参数， 他们和宽高相关，
        // 但它们其实不是宽和高， 而是由宽、高和各自方向上对应的测量模式来合成的一个值
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)//取出宽度确切的数值
        var widthmode = MeasureSpec.getMode(widthMeasureSpec)//取出宽度的测量模式

        var heightSize = MeasureSpec.getSize(heightMeasureSpec)//取出高度的确切数值
        var heihgtmode = MeasureSpec.getMode(heightMeasureSpec)//取出高度的测量模式

        //测量模式一共有三种
        //UNSPECIFIED   00  默认值，父控件没有给子view任何限制，子View可以设置为任意大小。
        //EXACTLY   01  表示父控件已经确切的指定了子View的大小。
        //AT_MOST   10  表示子View具体大小没有尺寸限制，但是存在上限，上限一般为父View大小。

        //如果对view的宽高进行了修改 不要调用 super.onMeasure(widthMeasureSpec,heightMeasureSpec);
        // 要调用setMeasuredDimension这个函数

    }

    //3--确定view的大小
    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //View的大小不仅由View本身控制，而且受父控件的影响，所以我们在确定View大小的时候
        // 最好使用系统提供的onSizeChanged回调函数。
    }

    //4--确定子View布局(包含子View时用,自定义ViewGroup中会用到,然后直接调用子View的layout函数)
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        //这个函数在视图大小发生改变时调用。
        //View的大小不仅由View本身控制，而且受父控件的影响，所以我们在确定View大小
        // 的时候最好使用系统提供的onSizeChanged回调函数。
    }

    var mPaint = Paint()

    //5--实际绘制内容
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(100F, 100F, 800F, 400F, mPaint)
        var rect = Rect(100,100,800,400)
        canvas.drawRect(rect,mPaint)
        var rectF = RectF(100F,100F,800F,400F)
        canvas.drawRect(rectF,mPaint)

        canvas.drawRoundRect(rectF,30F,30F,mPaint)
        canvas.drawRoundRect(100F, 100F, 800F, 400F,30F,30F, mPaint)

    }

    //--用户操作或者自身变化引起的视图状态改变
    override fun invalidate() {
        super.invalidate()
    }


    /**
     *
     * 1	构造函数	View初始化
    2	onMeasure	测量View大小
    3	onSizeChanged	确定View大小
    4	onLayout	确定子View布局(自定义View包含子View时有用)
    5	onDraw	实际绘制内容
    6	提供接口	控制View或监听View某些状态。
     */

}