package com.kky.example.widget.canvas

import android.content.Context
import android.graphics.*
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import com.kky.example.R
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit
import android.os.Message
import android.util.Log


/*
* @author Zeus
* create at 2019/4/28 11:55
* modify at 2019/4/28 11:55
* modify because 
* description: TO FIT
*/
class CheckView : View {
    private var mPaint = Paint()
    private var mWidth: Float = 0f
    private var mHeight: Float = 0f
    private val ANIM_NULL = 0         //动画状态-没有
    private val ANIM_CHECK = 1        //动画状态-开启
    private val ANIM_UNCHECK = 2      //动画状态-结束
    private lateinit var okBitmap: Bitmap


    private lateinit var mContext: Context           // 上下文
    private lateinit var mHandler: Handler// handler
    private var animCurrentPage = -1       // 当前页码
    private val animMaxPage = 13           // 总页数
    private var animDuration = 500         // 动画时长
    private var animState = ANIM_NULL      // 动画状态
    private var isCheck = false        // 是否只选中状态

    constructor(context: Context) : this(context, null)

    lateinit var disposable: Disposable

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {
        mContext = context
        mPaint.style = Paint.Style.FILL
        mPaint.isAntiAlias = true
        okBitmap = BitmapFactory.decodeResource(mContext!!.resources, R.drawable.checkmark)
        initHandler()
    }

    private fun initHandler() {
        mHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                if (animCurrentPage < animMaxPage && animCurrentPage >= 0) {
                    invalidate()
                    if (animState === ANIM_NULL)
                        return
                    if (animState === ANIM_CHECK) {

                        animCurrentPage++
                    } else if (animState === ANIM_UNCHECK) {
                        animCurrentPage--
                    }

                    this.sendEmptyMessageDelayed(0, animDuration / animMaxPage.toLong())
                    Log.e("AAA", "Count=$animCurrentPage")
                } else {
                    if (isCheck) {
                        animCurrentPage = animMaxPage - 1
                    } else {
                        animCurrentPage = -1
                    }
                    invalidate()
                    animState = ANIM_NULL
                }
            }
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w.toFloat()
        mHeight = h.toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // 移动坐标系到画布中央
        canvas.translate(mWidth / 2, mHeight / 2)
        mPaint.color = Color.GREEN

        // 绘制背景圆形
        canvas.drawCircle(0f, 0f, 240f, mPaint)

        // 得出图像边长
        val sideLength = okBitmap.height

        // 得到图像选区 和 实际绘制位置
        val src = Rect(sideLength * animCurrentPage,
                0, sideLength * (animCurrentPage + 1), sideLength)
        val dst = Rect(-200, -200, 200, 200)

        // 绘制
        canvas.drawBitmap(okBitmap, src, dst, null)
    }

    /**
     * 选择
     */
    fun check() {
        if (animState !== ANIM_NULL || isCheck)
            return
        animState = ANIM_CHECK
        animCurrentPage = 0
        isCheck = true
        doAnimation(true)
//        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage.toLong())
    }

    /**
     * 取消选择
     */
    fun unCheck() {
        if (animState !== ANIM_NULL || !isCheck)
            return
        animState = ANIM_UNCHECK
        animCurrentPage = animMaxPage - 1
//        mHandler.sendEmptyMessageDelayed(0, animDuration / animMaxPage.toLong())
        isCheck = false
        doAnimation(false)
    }

    /**
     * 执行定时任务
     */
    fun doAnimation(add: Boolean) {
        var count: Long = if (add) 1 else -1
        if (animState == ANIM_NULL) {
            return
        }
        if(isCheck != add){
            disposable.dispose()
        }else{
            disposable = Observable.interval(animDuration / animMaxPage.toLong(), animDuration / animMaxPage.toLong(), TimeUnit.MILLISECONDS).map(object : Function<Long, Long> {
                override fun apply(t: Long): Long {
                    return t + count
                }
            }).subscribe(
                    Consumer<Long> {
                        animCurrentPage = it.toInt()
                        if (add) {
                            if (animCurrentPage >= animMaxPage) {
                                animCurrentPage = animMaxPage - 1
                                disposable.dispose()
                            }
                        } else {
                            if (animCurrentPage < 0) {
                                animCurrentPage = -1
                                disposable.dispose()
                            }
                        }
                        invalidate()
                        animState = ANIM_NULL
                    }
            )
        }
    }

    /**
     * 设置动画时长
     *
     * @param animDuration
     */
    fun setAnimDuration(animDuration: Int) {
        if (animDuration <= 0)
            return
        this.animDuration = animDuration
    }

    /**
     * 设置背景圆形颜色
     * @param color
     */
    override fun setBackgroundColor(color: Int) {
        mPaint.color = color
    }

}